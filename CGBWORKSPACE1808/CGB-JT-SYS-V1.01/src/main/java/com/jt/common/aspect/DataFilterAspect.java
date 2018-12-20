package com.jt.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class DataFilterAspect {

	@Pointcut("@annotation(com.jt.common.anno.DataFilter)")
	public void doFilterPointCut(){
		
	}
	
}
