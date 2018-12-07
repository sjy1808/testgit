package day1503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws Exception, IOException {
		//���ӷ�����
		Socket s=new Socket("172.88.7.136",8000);
		//��
		BufferedReader in=new BufferedReader(
				new InputStreamReader(s.getInputStream(),"UTF-8"));
		PrintWriter out=new PrintWriter(
				new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
		while(true){
			System.out.println("���룺");
			String str = new Scanner(System.in).nextLine();
			out.println(str);//���͵�������
			out.flush();
			str=in.readLine();//���ջ���
			if(str==null){
				break;
			}
			System.out.println("������"+str);
		}
	}
}
