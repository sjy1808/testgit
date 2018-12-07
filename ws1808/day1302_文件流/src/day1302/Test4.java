package day1302;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) throws Exception {
		f1();
		System.out.println("\n\n--------------\n\n");
		f2();
	}

	private static void f1() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");
		byte[] buff=new byte[5];
		int n;//保存每一批的数量
		
		//从文件读取第一批数据，存到指定的数组
		//并返回这一批的字节量
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		n=in.read(buff);
		System.out.println(n+":"+Arrays.toString(buff));
		
	}

	private static void f2() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");
		//批量循环读取，标准格式
		byte[] buff=new byte[5];
		int n;//保存每一批的数量
		while((n=in.read(buff))!=-1){
			System.out.println(n+":"+Arrays.toString(buff));
		}
		in.close();
	}
}
