package day1304;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test4 {
	public static void main(String[] args) throws Exception {
		f1();
		System.out.println("------------");
		f2();
	}

	private static void f1() throws Exception {
		FileInputStream in=new FileInputStream("d:/abc/f2");
		long t=System.currentTimeMillis();
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
		t=System.currentTimeMillis()-t;
		System.out.println(t);
		in.close();
		
	}

	private static void f2() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f2");
		long t=System.currentTimeMillis();
		int b;
		while((b=in.read())!=-1){
			System.out.println(b);
		}
		t=System.currentTimeMillis()-t;
		System.out.println(t);
		
		in.close();
		
	}
}
