package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import cn.tedu.common.ServletContext;
import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

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
			//当客户端尝试连接服务器时,request.getUri()就是空的
			if(request.getUri()!=null&&request.getUri().length()>0){
				
			
				
				//声明响应对象
				HttpResponse response=new HttpResponse(socket.getOutputStream());
				
				//拼接响应头Content-Length
				/*String data="sdwhrt";
			ps.println("Content-Length:"+data.getBytes());*/
				//响应网页文件index.html
				/*File file =new File("WebContent/index.html");*/
				File file =new File(ServletContext.webRoot+request.getUri());
				
				//配置404页面
				//判断文件是否存在
				if(!file.exists()){
					//如果文件不存在,跳转404.html
					file=new File(ServletContext.webRoot+"/"+ServletContext.notFound);
					
					//设置404状态码
					response.setStatus(404);
				}else {
					response.setStatus(200);
				}
				
				//给响应参数设置值
				response.setProtocol(ServletContext.protocol);
				
				
				response.setContentType(getByMap(file));
				
				
				response.setContentLength((int)file.length());
				
				//响应数据
				/*ps.write(data.getBytes());*/
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
