package day1503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	//启动服务器的方法
	//在其中，要启动一个服务线程
	public void start(){
		new Thread(){
			@Override
			public void run() {
				try {
					//8000端口上启动服务
					ServerSocket ss= new ServerSocket(8000);
					System.out.println("服务已启动");
					//循环等待多个客户连接
					while(true){
						Socket s = ss.accept();
						//创建通信线程，并把连接通道s，交给这个线程来执行通信操作
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("端口被占用，或服务已停止");
				}
			}
		}.start();
	}
	
	static class TongXinThread extends Thread{
		Socket s;

		public TongXinThread(Socket s) {
			super();
			this.s = s;
		}
		@Override
		public void run() {
			try {
				BufferedReader in=new BufferedReader(
						new InputStreamReader(s.getInputStream(),"UTF-8"));
				PrintWriter out=new PrintWriter(
						new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
				String line;
				while((line=in.readLine())!=null){
					out.println(line);
					out.flush();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("客户端已断开连接");
		}
	}
	public static void main(String[] args){
		EchoServer server=new EchoServer();
		server.start();
	}
}
