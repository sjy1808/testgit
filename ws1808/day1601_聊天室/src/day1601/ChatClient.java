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
			System.out.println("�ǳƣ�");
			String n = new Scanner(System.in).nextLine();
			out.println(n);
			out.flush();
			
			//��������������
			new Thread(){
				@Override
				public void run() {
					receieve();
				}
			}.start();
			//�û�����
			new Thread(){
				@Override
				public void run() {
					input();
				}
			}.start();
			//��ӡ�߳�
			new Thread(){
				@Override
				public void run() {
					print();
				}
			}.start();
		} catch (Exception e) {
			System.out.println("�޷����ӷ��������������ѶϿ�");
			e.printStackTrace();
		}
	}
	protected void print() {
		while(true){
			synchronized (list) {
				while(inputFlag||list.size()==0){
					try {
						list.wait();//û������ʱ�ȴ�
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
		System.out.println("�Ѿ���������Ͽ�����");
	}
	protected void input() {
		System.out.println("���س�������������");
		while(true){
			new Scanner(System.in).nextLine();
			inputFlag=true;//��������״̬
			
			System.out.println("�����������ݣ�");
			String s = new Scanner(System.in).nextLine();
			out.println(s);
			out.flush();
			
			inputFlag=false;//������״̬
			synchronized (list) {
				list.notifyAll();//֪ͨ�ȴ��Ĵ�ӡ�̼߳�����ӡ
			}
		}
	}
	public static void main(String[] args) {
		ChatClient client=new ChatClient();
		client.start();
	}
}
