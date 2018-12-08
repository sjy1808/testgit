package day1402;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test3 {
	public static void main(String[] args) throws Exception, Exception {
		/*
		 * Unicode����
		 * 20902
		 * ���ķ�Χ\u4e00��\u9fa5
		 * f5(GBK)
		 * f6(UTF-8)
		 */
		f("d:/abc/f5","GBK");
		f("d:/abc/f6","UTF-8");
		
	}
	private static void f(String path, String encoding) throws Exception, IOException{
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
