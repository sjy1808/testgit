package day1301;

import java.io.File;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入文件夹：");
		String s = new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(!dir.isDirectory()){
			System.out.println("不是文件夹");
			return;
		}
		String[] names = dir.list();
		File[] files = dir.listFiles();
		if(names==null){
			System.out.println("无法获得目录列表");
			return;
		}
		for(String n:names){
			System.out.println(n);
		}
		System.out.println("\n\n---------------\n\n");
		for(File f:files){
			System.out.println(f.getName()+":"+f.length());
		}
	}
}
