package day1303;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test1 {
	public static void main(String[] args) throws Exception, IOException {
		Student s = new Student(9517,"����","��",45);
		/*
		 * ��ѧ������s�����л�������浽d:/abc/f2
		 * 
		 * ObjectOutputStream--FOS---f2
		 * 
		 */
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("d:/abc/f2"));
		
		out.writeObject(s);
		
		out.close();
		
	}
}
