package day1502;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//�������������������
		Socket s = new Socket("127.0.0.1",8000);
		//ȡ��˫�����
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//����5���ַ�hello
		out.write("hello".getBytes());
		out.flush();
		//ѭ��5�Σ�����5���ַ�World
		for(int i=0;i<5;i++){
			char c=(char)in.read();
			System.out.print(c);
		}
		//�Ͽ�����
		s.close();
	}
}
