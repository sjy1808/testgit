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
		//连接服务器
		Socket s=new Socket("172.88.7.136",8000);
		//流
		BufferedReader in=new BufferedReader(
				new InputStreamReader(s.getInputStream(),"UTF-8"));
		PrintWriter out=new PrintWriter(
				new OutputStreamWriter(s.getOutputStream(),"UTF-8"));
		while(true){
			System.out.println("输入：");
			String str = new Scanner(System.in).nextLine();
			out.println(str);//发送到服务器
			out.flush();
			str=in.readLine();//接收回声
			if(str==null){
				break;
			}
			System.out.println("回声："+str);
		}
	}
}
