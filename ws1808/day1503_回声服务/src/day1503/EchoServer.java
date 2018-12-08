package day1503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	//�����������ķ���
	//�����У�Ҫ����һ�������߳�
	public void start(){
		new Thread(){
			@Override
			public void run() {
				try {
					//8000�˿�����������
					ServerSocket ss= new ServerSocket(8000);
					System.out.println("����������");
					//ѭ���ȴ�����ͻ�����
					while(true){
						Socket s = ss.accept();
						//����ͨ���̣߳���������ͨ��s����������߳���ִ��ͨ�Ų���
						TongXinThread t = new TongXinThread(s);
						t.start();
					}
				} catch (Exception e) {
					System.out.println("�˿ڱ�ռ�ã��������ֹͣ");
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
			
			System.out.println("�ͻ����ѶϿ�����");
		}
	}
	public static void main(String[] args){
		EchoServer server=new EchoServer();
		server.start();
	}
}
