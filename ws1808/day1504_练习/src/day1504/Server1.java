package day1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//ѡ��8000�˿ڣ���8000�˿�������������
		ServerSocket ss= new ServerSocket(8000);
		System.out.println("������������");
		//��8000�˿��ϵȴ��ͻ��˷�������
		Socket s= ss.accept();
		//��Socket���ӣ�ȡ��˫�����
		InputStream in=s.getInputStream();
		OutputStream out=s.getOutputStream();
		/*
		 * ͨ��Э�飺
		 * 	ͨ�ŵ�ִ������
		 * 	ͨ�ŵ����ݸ�ʽ
		 * 		�ͻ�������������� hello
		 * 		��������ͻ��˷��� world
		 * 	ѭ��5�Σ�����hello����ַ����ֽ�ֵ
		 * 
		 */
		System.out.println("�ӿͻ��˽��գ�");
		for(int i=0;i<5;i++){
			char c=(char) in.read();
			System.out.println(c);
		}
		System.out.println("��ͻ��˷��� world");
		out.write("world".getBytes());
		out.flush();
		s.close();
		ss.close();
		
	}
}
