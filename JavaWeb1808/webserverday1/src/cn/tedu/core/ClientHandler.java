package cn.tedu.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import cn.tedu.http.HttpRequest;

/**
 * 这个类用来优化WebServer,是一个线程类
 *3.2.1  实现线程类
 *3.2.2  声明Socket对象
 *3.2.3  在构造函数中初始化socket，并且当做参数
 *3.2.4  重写run方法，提取响应代码
 */

//实现线程类
public class ClientHandler implements Runnable{
	
	//声明Socket对象
	private Socket socket;
	
	//在构造函数中初始化socket，并且当做参数
	public ClientHandler(Socket socket){
		this.socket=socket;
	}
	
	//重写run方法，提取响应代码
	@Override
	public void run() {
		try {
			//利用请求对象完成请求数据处理
			HttpRequest request=new HttpRequest(socket.getInputStream());
			//当客户端尝试连接服务器时,request.getUri()就是空的
			if(request.getUri()!=null&&request.getUri().length()>0){
				
			/*//获取请求行
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(socket.getInputStream()));//InputStreamReader把字节流转化成字符流
			
			String line=reader.readLine();//请求行
			System.out.println(line);
			if(line!=null&&line.length()>0){
				
				//根据空格切割字符串
				//按照角标获取第二个元素(给问号赋值)
				String[] strs=line.split(" ");
				String uri=strs[1];
				
				//给网站设置默认主页
				//当不指定要访问的资源时,localhost:8080,这是uri的值是/
				if(uri.equals("/")){
					uri="/index.html";
				}*/
				
				
				//拼接响应头
				PrintStream ps=new PrintStream(socket.getOutputStream());
				
				//拼接状态行
				ps.println("HTTP/1.1 200 OK");
				
				//拼接响应头Content-Type
				ps.println("Content-Type:text/html");
				
				//拼接响应头Content-Length
				/*String data="sdwhrt";
			ps.println("Content-Length:"+data.getBytes());*/
				//响应网页文件index.html
				/*File file =new File("WebContent/index.html");*/
				File file =new File("WebContent"+request.getUri());
				ps.println("Content-Length:"+file.length());
				
				
				//空白行
				ps.println();
				//响应数据
				/*ps.write(data.getBytes());*/
				//响应网页文件
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				byte[] b=new byte[(int) file.length()];
				bis.read(b);//读文件
				
				ps.write(b);//写文件
				ps.flush();
				socket.close();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
