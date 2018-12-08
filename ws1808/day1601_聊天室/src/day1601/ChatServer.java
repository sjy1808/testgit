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
					//��������
					ServerSocket ss = new ServerSocket(8000);
					System.out.println("�����ҷ������Ѿ�����");
					//ѭ���ȴ��ͻ�������
					while(true){
						Socket s = ss.accept();
						TongXinThread t = new TongXinThread(s);
						t.start();
						synchronized(list){
							list.add(t);
						}
					}
					
				} catch (Exception e) {
					System.out.println("�޷���������������������Ѿ�ֹͣ");
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
				//���տͻ��˵��ǳ�
				this.name=in.readLine();
				//���ͻ��˷��ͻ�ӭ��Ϣ
				send("��ӭ���뼤�������ң�");
				//Ⱥ��������Ϣ
				sendAll(name+"������������");
				synchronized (list) {
					sendAll("����������"+list.size());
				}
				String line;
				while((line=in.readLine())!=null){
					sendAll(name+"˵��"+line);
				}
				
			} catch (Exception e) {
			}
			//�Ƴ���ǰͨ���̶߳���
			synchronized (list) {
				list.remove(this);
			}
			//Ⱥ��������Ϣ
			sendAll(name+"�뿪��������");
			synchronized (list) {
				sendAll("����������"+list.size());
			}
			
		}
	}
	public static void main(String[] args) {
		ChatServer server =new ChatServer();
		server.start();
	}
}
