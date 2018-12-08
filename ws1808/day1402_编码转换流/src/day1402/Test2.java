package day1402;

import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Test2 {
	public static void main(String[] args) throws Exception {
		f("d:/abc/f3","GBK");
		f("d:/abc/f4","UTF-8");
	}

	private static void f(String path, String encoding) throws Exception{
		/*
		 * ISR---FIS---path
		 * encoding
		 * 
		 */
		InputStreamReader in=
				new InputStreamReader(
				new FileInputStream(path),encoding);
		int c;
		while((c=in.read())!=-1){
			System.out.println((char)c);
		}
		System.out.println("\n\n");
		in.close();
		
	}
}
