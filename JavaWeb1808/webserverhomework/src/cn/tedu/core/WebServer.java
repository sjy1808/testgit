package cn.tedu.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.tedu.common.ServletContext;

/**
 * 用来代表服务器端的程序
 * 1.声明ServerSocket对象
 * 2.在构造函数中完成对象的初始化
 * 3.创建start方法,主要用来接收请求和作出响应
 * 4.创建main方法,启动服务器
 */
/**
 * 改造WebServer类,执行线程类
 * 1.1.声明线程池对象ExecutorService
 * 1.2.在构造函数中初始化线程池
 * 1.3.执行线程类
 */
public class WebServer {
	//1.声明ServerSocket对象
	private ServerSocket server;
	//1.1声明线程池对象
	private ExecutorService pool;
	//2.在构造函数中完成对象的初始化
	public WebServer(){
		try {
//			server = new ServerSocket(8080);
			server = new ServerSocket(ServletContext.port);
			//1.2在构造函数中初始化线程池
//			pool=Executors.newFixedThreadPool(100);
			pool=Executors.newFixedThreadPool(ServletContext.maxSize);
			System.out.println("start...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//3.创建start方法,主要用来接收请求和作出响应
	public void start(){
		try {
			while(true){
			//主要用来接收请求
				Socket socket=server.accept();
				
				//1.3执行线程类
				pool.execute(new ClientHandler(socket));
			}
			/*Thread thread = new Thread(new ClientHandler(socket));
			thread.start();*/
			//作出响应
			/*OutputStream out=socket.getOutputStream();
			输出数据
			 * 问题:输出数格式不符合Http协议,无法展示
			 * Http协议的格式
			 * 响应头: HTTP/1.1 200 OK
			 * 若干响应头:Content-Type/Content-Length/Date
			 * 空白行:用来分割若干响应头和响应实体
			 * 响应实体:真正要显示的数据
			 * 
			out.write("skfalfien".getBytes());
			out.flush();
			
			//拼接响应头
			PrintStream ps=new PrintStream(out);
			//拼接状态行
			ps.println("HTTP/1.1 200 OK");
			//拼接响应头Content-Type
			//响应内容的类型:文本或网页
			ps.println("Content-Type:text/html");
			//拼接响应头Content-Length
			//响应内容的长度
			String data="djfie";
			ps.println("Content-Length:"+data.length());
			
			//空白行
			ps.println();
			
			//响应数据
			ps.write(data.getBytes());
			ps.flush();
			socket.close();*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//4.创建main方法,启动服务器
	public static void main(String[] args) {
		WebServer server=new WebServer();
		server.start();
	}
}
