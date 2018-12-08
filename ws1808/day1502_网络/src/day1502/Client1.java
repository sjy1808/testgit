package day1502;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args) throws Exception {
		//主动与服务器建立连接
		Socket s = new Socket("127.0.0.1",8000);
		//取出双向的流
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		//发送5个字符hello
		out.write("hello".getBytes());
		out.flush();
		//循环5次，接收5个字符World
		for(int i=0;i<5;i++){
			char c=(char)in.read();
			System.out.print(c);
		}
		//断开连接
		s.close();
	}
}
