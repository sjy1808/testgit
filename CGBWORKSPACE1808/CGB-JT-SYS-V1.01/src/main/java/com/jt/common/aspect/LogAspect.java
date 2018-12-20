package com.jt.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.anno.RequiresLog;
import com.jt.common.util.IPUtils;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysUser;
import com.jt.sys.entity.Syslog;

/**
 * 面向切面编程(AOP)中的切面对象
 * @author Administrator
 *
 */
@Service
@Aspect//此注解用于描述这个类是一个切面类
public class LogAspect {

	/**通过此方法定义一个切入点(PointCut)
	 * 其中:
	 * bean(sysUserServiceImpl)为一个切入点表达式
	 * 此表达式只能实现粗粒度的切入点设计
	 * 
	 * bean(*ServiceImpl)
	 * */
	@Pointcut("@annotation(com.jt.common.anno.RequiresLog)")
	public void doLogPointCut(){
		/**
		 * 可以将此方法理解为一个通知(在目标方法上扩展业务)
		 * 在哪些方法执行织入扩展功能
		 * @Around 修饰的方法为一个环绕通知?
		 * 在目标方法执行之前,之后都可以添加扩展业务
		 * @Param ProceedingJoinPoint为一个连接点对象,此
		 * 对象封装的是目标对象中对应目标方法信息
		 */
		
	}
	@Around("doLogPointCut()")//环绕通知
	public Object around(ProceedingJoinPoint jp)throws Throwable{
		//记录时间
		long t1=System.currentTimeMillis();
		//执行目标方法(如何获取目标方法以及目标对象)
		Object result=jp.proceed();
		//记录时间
		long t2=System.currentTimeMillis();
		System.out.println("totalTime="+(t2-t1));
		//将日志信息写入到数据库
		saveObject(jp,(t2-t1));
		return result;
	}
	private void saveObject(ProceedingJoinPoint jp, long time) throws NoSuchMethodException, SecurityException {
		//获取目标对象类型
		Class<?> targetCls=jp.getTarget().getClass();
		//获取目标对象方法
		MethodSignature ms =(MethodSignature) jp.getSignature();
		Method method=targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
		String methodName=targetCls.getName()+"."+method.getName();
//		targetCls.getDeclaredMethod(name, parameterTypes);
		System.out.println(methodName+".totalTime="+time);
		//获取目标方法执行时传递的实际参数
		Object[] args = jp.getArgs();
		System.out.println("args="+Arrays.toString(args));
		//获取方法对应的操作
		//获取方法上定义的注解
		RequiresLog requiresLog = method.getDeclaredAnnotation(RequiresLog.class);
		//获取注解中定义的操作
		String operation=requiresLog.value();
		//获取此操作的用户
		SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
		String username=user.getUsername();
		//获取当前用户的IP地址
		String ip=IPUtils.getIpAddr();
		//封装用户行为日志
		Syslog log=new Syslog();
		log.setUsername(username);
		log.setOperation(operation);
		log.setMethod(methodName);
		log.setParams(Arrays.toString(args));
		log.setTime(time);
		log.setIp(ip);
		log.setCreatedTime(new Date());
		//将日志持久化到数据库
		sysLogDao.insertObject(log);
	}
	@Autowired
	private SysLogDao sysLogDao;
}
