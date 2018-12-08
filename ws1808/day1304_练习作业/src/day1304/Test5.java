package day1304;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Test5 {
	public static void main(String[] args) throws Exception {
		f1();
		System.out.println("-----------");
		f2();
		
	}

	private static void f1() throws Exception {
		FileInputStream in=new FileInputStream("d:/abc/di.wmv");
		byte[] buff=new byte[8192];
		int n;
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
		in.close();
		
		
		
		
	}

	private static void f2() throws Exception {
		FileInputStream in = new FileInputStream("d:/abc/f2");
		long t=System.currentTimeMillis();
		byte[] buff=new byte[8192];
		int n;
		while((n=in.read(buff))!=-1){
			System.out.println(n+":"+Arrays.toString(buff));
		}
		t=System.currentTimeMillis()-t;
		System.out.println(t);
		in.close();
	}
}
