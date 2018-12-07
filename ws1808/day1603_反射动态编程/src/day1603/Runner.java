package day1603;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class Runner {
	public static void run() throws Exception{
		/*
		 * 类对象提供一个方法
		 * 可以用相对路径的格式
		 * 来获取文件的完整路径
		 * 
		 * "/"这个类的存放目录
		 * 		就是bin目录
		 * "/cfg.txt"-->D:\ws1808\day1603_反射动态编程\bin\cfg.txt
		 * "/day1603/cfg.txt"
		 */
		String path=Runner.class.getResource("/cfg.txt").getPath();
		//URL编码格式-解码->字符
		path=URLDecoder.decode(path,"UTF-8");
		//System.out.println(path);
		BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String line;
		while((line=in.readLine())!=null){
			line =line.trim();
			if(line.length()==0) continue;
			
			run(line);//"day1603.A;a"
		}
		
		
	}
	private static void run(String line) throws Exception {
		String[] a=line.split(";");//拆分
		Class<?> c= Class.forName(a[0].trim());
		Object obj = c.newInstance();//无参构造
		//获得方法
		Method m = c.getMethod(a[1].trim());
		//执行方法
		m.invoke(obj);
	}
	/*public static void main(String[] args) throws Exception {
		Runner.run();
	}*/
}
