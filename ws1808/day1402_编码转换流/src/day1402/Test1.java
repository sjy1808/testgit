package day1402;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Test1 {
	public static void main(String[] args) throws Exception, Exception {
		/*
		 * f3(GBK)�ļ�:
		 *   a��
		 *   61 d6 d0
		 * f4(UTF-8)�ļ���
		 *   a��
		 *   61 e4 b8 ad
		 */
		f("d:/abc/f3","GBK","abc���Ć��F");
		f("d:/abc/f4","UTF-8","abc���Ć��F");
		
		
	}

	private static void f(String path, String encoding, String s) throws Exception, IOException {
		//OSW--FOS--path
		//OSWָ������encoding
		OutputStreamWriter out=
				new OutputStreamWriter(
				new FileOutputStream(path),encoding);
		out.write(s);
		out.close();
	}
}
