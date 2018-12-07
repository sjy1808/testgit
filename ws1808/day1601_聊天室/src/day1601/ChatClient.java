package day1601;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;
	private LinkedList<String> list=new LinkedList<>();
	private boolean inputFlag=false;
	public void start(){
		try {
			s=new Socket("172.88.7.137",8000);
			in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			out =new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
			System.out.println("昵称：");
			String n = new Scanner(System.in).nextLine();
			out.println(n);
			out.flush();
			
			//接收聊天室内容
			new Thread(){
				@Override
				public void run() {
					receieve();
				}
			}.start();
			//用户输入
			new Thread(){
				@Override
				public void run() {
					input();
				}
			}.start();
			//打印线程
			new Thread(){
				@Override
				public void run() {
					print();
				}
			}.start();
		} catch (Exception e) {
			System.out.println("无法连接服务器，或连接已断开");
			e.printStackTrace();
		}
	}
	protected void print() {
		while(true){
			synchronized (list) {
				while(inputFlag||list.size()==0){
					try {
						list.wait();//没有数据时等待
					} catch (Exception e) {
					}
				}
				String str=list.removeFirst();
				System.out.println(str);
			}
		}
	}
	protected void receieve() {
		try {
			String line;
			while((line=in.readLine())!=null){
				synchronized (list) {
					list.add(line);
					list.notifyAll();
				}
			}
		} catch (Exception e) {
		}
		System.out.println("已经与服务器断开连接");
	}
	protected void input() {
		System.out.println("按回车输入聊天内容");
		while(true){
			new Scanner(System.in).nextLine();
			inputFlag=true;//进入输入状态
			
			System.out.println("输入聊天内容：");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
			
			inputFlag=false;//非输入状态
			synchronized (list) {
				list.notifyAll();//通知等待的打印线程继续打印
			}
		}
	}
	public static void main(String[] args) {
		ChatClient client=new ChatClient();
		client.start();
	}
}
