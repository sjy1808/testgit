package day1404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		System.out.println("原文件：");
		String s1 = new Scanner(System.in).nextLine();
		File from=new File(s1);
		if(!from.isFile()){
			System.out.println("不是文件");
			return;
		}
		System.out.println("目标文件：");
		String s2 = new Scanner(System.in).nextLine();
		File to=new File(s2);
		if(to.isDirectory()){
			System.out.println("输入文件，不能是文件夹");
			return;
		}
		System.out.println("原文件编码：");
		String fromset = new Scanner(System.in).nextLine();
		System.out.println("目标文件编码：");
		String toset= new Scanner(System.in).nextLine();
		try {
			copy(from,to,fromset,toset);
			System.out.println("完成复制");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("失败");
		}
	}

	private static void copy(File from, File to, String fromset, String toset) throws Exception, Exception {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(
				 		new InputStreamReader(
				 		new FileInputStream(from),fromset));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(to), toset));
		String line;
		while((line=in.readLine())!=null){
			out.write(line);
		}
		out.close();
		in.close();
	}
}
