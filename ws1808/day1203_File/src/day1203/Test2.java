package day1203;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		/*
		 * �½�һ���ļ��У�
		 * d:/abc
		 * 
		 * �½��ļ�
		 * d:/abc/f1
		 * 
		 * ɾ���ļ�
		 * d:/abc/f1
		 * 
		 * ɾ���ļ���
		 *  d:/abc
		 */
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		File dir = new File("d:/abc");
		dir.mkdirs();
		
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		File f = new File("d:/abc/f1");
		f.createNewFile();
		
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		f.delete();
		
		System.out.println("���س�");
		new Scanner(System.in).nextLine();
		dir.delete();
		
		
		
	}
}
