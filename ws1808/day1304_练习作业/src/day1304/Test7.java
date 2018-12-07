package day1304;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test7 {
	public static void main(String[] args) throws Exception, IOException {
		Student s = new Student(4545,"ÌÀÄ·¿ËÂ³Ë¹","ÄÐ",45);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("d:/abc/f2"));
		out.writeObject(s);
		out.close();
		
		
	}
}
