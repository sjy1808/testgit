package day1404;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test3 {
	public static void main(String[] args) throws Exception {
		f("d:/abc/f3","GBK","abc����˵�޾Ϳކ��F");
		f("d:/abc/f4","UTF-8","asd���Ć��F");
	}

	private static void f(String path, String encoding, String s) throws Exception, IOException {
		// TODO Auto-generated method stub
		OutputStreamWriter out = new OutputStreamWriter(
		new FileOutputStream(path),encoding);
		out.write(s);
		out.close();
	}
}
