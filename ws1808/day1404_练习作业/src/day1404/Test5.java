package day1404;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test5 {
	public static void main(String[] args) throws Exception {
		f("d:/abc/f5","GBK");
		
		f("d:/abc/f6","UTF-8");
	}

	private static void f(String path, String encoding) throws Exception, Exception {
		// TODO Auto-generated method stub
		OutputStreamWriter out=new OutputStreamWriter(
				new FileOutputStream(path),encoding);
		int count=0;
		for(char c='\u4e00';c<='\u9fa5';c++){
			out.write(c);
			count++;
			if(count==30){
				out.write('\n');
				count=0;
			}
		}
		out.close();
	}
}
