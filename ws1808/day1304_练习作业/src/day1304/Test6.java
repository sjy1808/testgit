package day1304;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		System.out.println("ԭ�ļ���");
		String s = new Scanner(System.in).nextLine();
		File from = new File(s);
		if(!from.isFile()){
			System.out.println("�����ļ�");
			return;
		}
		System.out.println("Ŀ���ļ���");
		String s1 = new Scanner(System.in).nextLine();
		File to = new File(s1);
		if(to.isDirectory()){
			System.out.println("�������ļ����������ļ���");
			return;
		}
		try {
			copy(from,to);
			System.out.println("�������");
		} catch (Exception e) {
			System.out.println("����ʧ��");
		}
	}

	private static void copy(File from, File to) throws Exception {
		/*FileInputStream in = new FileInputStream(from);
		FileOutputStream out=new FileOutputStream(to);*/
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(from));
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(to));
		
		long t=System.currentTimeMillis();
		int b;
		while((b=in.read())!=-1){
			out.write(b);
		}
		//byte[] buff=new byte[8192];
		/*int n;
		while((n=in.read(buff))!=-1){
			out.write(buff,0,n);
		}*/
		/*int n;
		while((n=in.read())!=-1){
			out.write(n);
		}*/
		t=System.currentTimeMillis()-t;
		System.out.println(t);
		in.close();
		out.close();
		
	}
	
}
