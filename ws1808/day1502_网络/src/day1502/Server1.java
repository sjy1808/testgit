package day1502;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws Exception {
		//ѡ��8000�˿ڣ���8000�˿�����������
		ServerSocket ss=new ServerSocket(8000);
		System.out.println("�����Ѿ�����");
		//��8000�˿��ϵȴ��ͻ��˷�������
		Socket s=ss.accept();
		//��Socket���ӣ�ȡ��˫�����
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		/*
		 * ͨ��Э�飺
		 * 		ͨ�ŵ�ִ������
		 * 		ͨ�ŵ����ݸ�ʽ
		 */
		//ѭ��5�Σ�����hello����ַ����ֽ�ֵ
		System.out.println("�ӿͻ��˽��գ�");
		for(int i=0;i<5;i++){
			char c= (char)in.read();
			System.out.print(c);
		}
		System.out.println("��ͻ��˷���Wold");
		out.write("world".getBytes());
		out.flush();
		s.close();//�Ͽ�����
		ss.close();//�ͷŶ˿ڣ�ֹͣ����
	}
}
