package day1203;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 新建一个文件夹：
		 * d:/abc
		 * 
		 * 新建文件
		 * d:/abc/f1
		 * 
		 * 删除文件
		 * d:/abc/f1
		 * 
		 * 删除文件夹
		 *  d:/abc
		 */
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		File dir = new File("d:/abc");
		dir.mkdirs();
		
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		File f = new File("d:/abc/f1");
		f.createNewFile();
		
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		f.delete();
		
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		dir.delete();
		
		
		
	}
}
