package day1304;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test3 {
	public static void main(String[] args) throws Exception {
		FileOutputStream out = new FileOutputStream("d:/abc/f1");
		out.write(97);
		out.write(98);
		out.write(99);
		out.write(356);
		byte[] a={101,102,103,104,105,106,107,108,109,110};
		out.write(a);
		out.write(a,3,4);
		out.close();
	}
}
