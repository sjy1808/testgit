package day1404;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Test4 {
	public static void main(String[] args) throws Exception, Exception {
		f("d:/abc/f3","GBK");
		f("d:/abc/f4","UTF-8");
	}

	private static void f(String path, String encoding) throws Exception, IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(
				new FileInputStream(path),encoding);
		int c;
		while((c=in.read())!=-1){
			System.out.println((char) c);
		}
		System.out.println("--------");
		in.close();
		
	}
}
