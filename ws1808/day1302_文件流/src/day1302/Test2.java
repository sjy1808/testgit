package day1302;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test2 {
	public static void main(String[] args) throws Exception {
		f1();
		System.out.println("\n\n-------------\n\n");
		f2();
		
	}

	private static void f1() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");
		int b;
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		b=in.read();
		System.out.println(b);
		
		in.close();
	}

	private static void f2() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f1");
		//单字节循环读取，标准格式
		int b;
		/*while(true){
			b=in.read();
			if(b==-1)break;
			System.out.println(b);
		}*/
		while((b=in.read())!=-1){
			System.out.println(b);
		}
		in.close();
	}
}
