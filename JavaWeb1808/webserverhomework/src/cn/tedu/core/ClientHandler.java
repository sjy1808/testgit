package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.tedu.common.HttpContext;
import cn.tedu.common.ServletContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;
import cn.tedu.utils.JDBCUtils;

/**
 * 这个类用来优化WebServer,是一个线程类
 * 1.实现线程类
 * 2.声明Socket对象
 * 3.在构造函数中初始化socket,并且当做参数
 * 4.重写run方法,提取响应代码
 */
//1.实现线程类
public class ClientHandler implements Runnable{
	//2.声明Socket对象
	private Socket socket;
	
	//在构造函数中初始化socket,并且当做参数
	public ClientHandler(Socket socket){
		this.socket=socket;
	}
	//重写run方法,提取响应代码
	@Override
	public void run() {
		try {
			/*//获取请求信息
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取请求行
			String line=reader.readLine();*/
			//利用请求对象完成请求数据处理
			HttpRequest request=new HttpRequest(socket.getInputStream());
			//声明响应的对象
			
			HttpResponse response=new HttpResponse(socket.getOutputStream());
			if(request.getUri()!=null&&request.getUri().length()>0){
				
				//判断用户是否要完成登录或者注册功能
				if(request.getUri().startsWith("/LoginUser")||request.getUri().startsWith("/RegistUser")){
					service(request,response);
					return;
				}
				
			/*if(line!=null&&line.length()>0){
				//根据空切割字符串,分割字符串
				String[] strs=line.split(" ");
				//按脚标获取第二个元素
				String uri=strs[1];
				//给网页设置默认主页,当不指定要访问的资源时,访问主页
				if(uri.equals("/")){
					uri="/index.html";
				}*/
				
				//拼接响应头
				/*PrintStream ps = new PrintStream(socket.getOutputStream());
				//拼接状态行
				ps.println("HTTP/1.1 200 OK");
				ps.println("Content-Type:text/html");*/
				//响应一个字符串
				/*String data="say goodbay!";
				ps.println("Content-Length:"+data.length());*/
				//响应网页文件
				//File file = new File("WebContent/index.html");
				//动态响应网页
				//File file = new File("WebContent"+uri);
				//动态获取
//				File file = new File("WebContent"+request.getUri());
				File file = new File(ServletContext.webRoot+request.getUri());
				
				//配置404页面
				//判断文件是否存在
				if(!file.exists()){
					file=new File(ServletContext.webRoot+"/"+ServletContext.notfound);
					//设置404的状态码
//					response.setStatus(404);
					response.setStatus(HttpContext.CODE_NOTFOUND);
				} else {
//					response.setStatus(200);
					response.setStatus(HttpContext.CODE_OK);
				}
				
				
				//给响应的4个参数设置值
//				response.setProtocol("HTTP/1.1");
				response.setProtocol(ServletContext.protocol);
//				response.setStatus(200);
//				response.setContentType("text/html");
				response.setContentType(getByMap(file));
				response.setContentLength((int)file.length());
				
				/*
				ps.println("Content-Length:"+file.length());
				
				ps.println("");*/
				//ps.write(data.getBytes());
				//响应网页文件
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] b=new byte[(int) file.length()];
				bis.read(b);//读文件
				/*ps.write(b);//写出文件
				
				ps.flush();*/
				response.getOutputStream().write(b);
				response.getOutputStream().flush();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//判断用户是否要完成登录
	private void service(HttpRequest request, HttpResponse response) {
		if(request.getUri().startsWith("/LoginUser")){
			//登录
			try {
				Connection conn=JDBCUtils.getConnection();
				String sql="select * from user where username=? and password=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					//rs.getString("username");
					System.out.println(rs.getString("username"));
				}
				response.setStatus(HttpContext.CODE_OK);
				response.setProtocol(ServletContext.protocol);
				
				//读出文件,响应出去
				File file=new File(ServletContext.webRoot+"/log_success.html");
				response.setContentType(getByMap(file));
				response.setContentLength((int)file.length());
				System.out.println(HttpContext.CODE_OK);
				System.out.println(ServletContext.protocol);
				System.out.println(getByMap(file));
				System.out.println((int)file.length());
				//响应文件
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] b=new byte[(int) file.length()];
				response.getOutputStream().write(b);
				response.getOutputStream().flush();
				socket.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getUri().startsWith("/RegistUser")){
			//注册
		}
	}
	
	
	//根据文件的扩展名去map中找value
	private String getByMap(File file) {
		String fileName=file.getName();
		String ext=fileName.substring(fileName.lastIndexOf(".")+1);
		String value=ServletContext.typeMap.get(ext);
		return value;
	}
	
}
