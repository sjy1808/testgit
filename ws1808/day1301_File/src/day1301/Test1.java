package day1301;

import java.io.File;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("�����ļ��У�");
		String s = new Scanner(System.in).nextLine();
		File dir = new File(s);
		if(!dir.isDirectory()){
			System.out.println("�����ļ���");
			return;
		}
		String[] names = dir.list();
		File[] files = dir.listFiles();
		if(names==null){
			System.out.println("�޷����Ŀ¼�б�");
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
