package day1601;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private List<TongXinThread> list=new ArrayList<>();
	public void start(){
		new Thread(){
			@Override
			public void run() {
				try {
					//启动服务
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("聊天室服务器已经启动");
					//循环等待客户端连接
					while(true){
						Socket s = ss.accept();
						TongXinThread t = new TongXinThread(s);
						t.start();
						synchronized(list){
							list.add(t);
						}
					}
					
				} catch (Exception e) {
					System.out.println("无法启动服务器，或服务器已经停止");
				}
			}
		}.start();
	}
	class TongXinThread extends Thread{
		private Socket s;
		private BufferedReader in;
		private PrintWriter out;
		private String name;

		public TongXinThread(Socket s) {
			super();
			this.s = s;
		}
		public void send(String msg){
			out.println(msg);
			out.flush();
		}
		public void sendAll(String msg){
			synchronized (list) {
				for (TongXinThread t : list) {
					t.send(msg);
				}
			}
		}
		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
				out =new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
				//接收客户端的昵称
				this.name=in.readLine();
				//给客户端发送欢迎信息
				send("欢迎进入激情聊天室！");
				//群发上线信息
				sendAll(name+"进入了聊天室");
				synchronized (list) {
					sendAll("在线人数："+list.size());
				}
				String line;
				while((line=in.readLine())!=null){
					sendAll(name+"说："+line);
				}
				
			} catch (Exception e) {
			}
			//移除当前通信线程对象
			synchronized (list) {
				list.remove(this);
			}
			//群发离线消息
			sendAll(name+"离开了聊天室");
			synchronized (list) {
				sendAll("在线人数："+list.size());
			}
			
		}
	}
	public static void main(String[] args) {
		ChatServer server =new ChatServer();
		server.start();
	}
}
