package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.tedu.common.HttpContext;
import cn.tedu.common.ServletContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;
import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来优化WebServer,是一个线程类
 *3.2.1  实现线程类
 *3.2.2  声明Socket对象
 *3.2.3  在构造函数中初始化socket，并且当做参数
 *3.2.4  重写run方法，提取响应代码
 */

//实现线程类
public class ClientHandler implements Runnable{
	
	//声明Socket对象
	private Socket socket;
	
	//在构造函数中初始化socket，并且当做参数
	public ClientHandler(Socket socket){
		this.socket=socket;
	}
	
	//重写run方法，提取响应代码
	@Override
	public void run() {
		try {
			//利用请求对象完成请求数据处理
			HttpRequest request=new HttpRequest(socket.getInputStream());
			//声明响应对象
			HttpResponse response=new HttpResponse(socket.getOutputStream());
			//当客户端尝试连接服务器时,request.getUri()就是空的
			if(request.getUri()!=null&&request.getUri().length()>0){
				
				//判断用户是否要完成登录或者注册功能
				if(request.getUri().startsWith("/LoginUser")||request.getUri().startsWith("/RegidtUser")){
					service(request,response);
					return;//让程序响应后就结束,不要继续执行了...
				}
				
				File file =new File(ServletContext.webRoot+request.getUri());
				
				//配置404页面
				//判断文件是否存在
				if(!file.exists()){
					//如果文件不存在,跳转404.html
					file=new File(ServletContext.webRoot+"/"+ServletContext.notFound);
					
					//设置404状态码
//					response.setStatus(404);
					response.setStatus(HttpContext.CODE_NOTFOUND);
				}else {
//					response.setStatus(200);
					response.setStatus(HttpContext.CODE_OK);
				}
				
				//给响应参数设置值
				response.setProtocol(ServletContext.protocol);
				
				response.setContentType(getByMap(file));
				
				response.setContentLength((int)file.length());
				
				//响应网页文件
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] b=new byte[(int) file.length()];
				bis.read(b);//读文件
				
				response.getOutputStream().write(b);//写文件
				response.getOutputStream().flush();
				socket.close();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//判断用户是否要完成登录
	//利用JDBC技术,查询user表的数据
	private void service(HttpRequest request, HttpResponse response) {
		if(request.getUri().startsWith("/LoginUser")){
			//登录
			try {
				//1.注册驱动获取连接
				Connection conn=JDBCUtils.getConnection();
				//2.获取传输器
				String sql="select * from user where username=? and password=?";
				PreparedStatement ps= conn.prepareStatement(sql);
				//3.设置sql参数
				ps.setString(1, request.getParameter("username"));
				ps.setString(2, request.getParameter("password"));
				//4.执行sql
				ps.executeQuery();
				
				//设置响应参数staus protocol
				//content-Type
				//content-Length 响应log_success.html
				response.setStatus(HttpContext.CODE_OK);
				response.setProtocol(ServletContext.protocol);
				
				//读出文件,响应出去...
				File file = new File(ServletContext.webRoot+"/log_success.html");
				response.setContentType(getByMap(file));
				response.setContentLength((int)file.length());
				
				//响应文件
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] b=new byte[(int) file.length()];
				bis.read(b);//读取文件
				response.getOutputStream().write(b);
				response.getOutputStream().flush();
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(request.getUri().startsWith("/RegidtUser")){
			//注册
			
		}
	}

	//根据文件的扩展名去map中找value
	private String getByMap(File file) {
		//文件名:in.d.ex.html
		String fileName=file.getName();
		//获取文件的后缀名
		String ext=fileName.substring(fileName.lastIndexOf(".")+1);
		//去map中找value
		String value=ServletContext.typeMap.get(ext);
		return value;
	}
	
}
