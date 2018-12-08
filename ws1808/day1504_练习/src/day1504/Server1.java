package day1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//选择8000端口，在8000端口上启动服务器
		ServerSocket ss= new ServerSocket(8000);
		System.out.println("服务器已启动");
		//在8000端口上等待客户端发起连接
		Socket s= ss.accept();
		//从Socket连接，取出双向的流
		InputStream in=s.getInputStream();
		OutputStream out=s.getOutputStream();
		/*
		 * 通信协议：
		 * 	通信的执行流程
		 * 	通信的数据格式
		 * 		客户端向服务器发送 hello
		 * 		服务器向客户端发送 world
		 * 	循环5次，接收hello五个字符的字节值
		 * 
		 */
		System.out.println("从客户端接收：");
		for(int i=0;i<5;i++){
			char c=(char) in.read();
			System.out.println(c);
		}
		System.out.println("向客户端发送 world");
		out.write("world".getBytes());
		out.flush();
		s.close();
		ss.close();
		
	}
}
