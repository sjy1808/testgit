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
		System.out.println("原文件：");
		String s = new Scanner(System.in).nextLine();
		File from = new File(s);
		if(!from.isFile()){
			System.out.println("不是文件");
			return;
		}
		System.out.println("目标文件：");
		String s1 = new Scanner(System.in).nextLine();
		File to = new File(s1);
		if(to.isDirectory()){
			System.out.println("输入是文件，不能是文件夹");
			return;
		}
		try {
			copy(from,to);
			System.out.println("复制完成");
		} catch (Exception e) {
			System.out.println("复制失败");
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
