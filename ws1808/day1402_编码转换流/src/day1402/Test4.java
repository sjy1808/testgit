package day1402;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		/*
		 * ԭ�ļ���
		 * Ŀ���ļ���
		 * ԭ�ļ����룺
		 * Ŀ���ļ����룺
		 */
		System.out.println("ԭ�ļ���");
		String s1 = new Scanner(System.in).nextLine();
		File from=new File(s1);
		if(!from.isFile()){
			System.out.println("�����ļ�");
			return;
		}
		System.out.println("Ŀ���ļ���");
		String s2 = new Scanner(System.in).nextLine();
		File to=new File(s2);
		if(to.isDirectory()){
			System.out.println("�����ļ����������ļ���");
			return;
		}
		System.out.println("ԭ�ļ����룺");
		String fromCharset=new Scanner(System.in).nextLine();
		System.out.println("Ŀ���ļ����룺");
		String toCharset=new Scanner(System.in).nextLine();
		try {
			copy(from,to,fromCharset,toCharset);
			System.out.println("���");
		} catch (Exception e) {
			System.out.println("ʧ��");
			e.printStackTrace();
		}
	}

	private static void copy(File from, File to, String fromCharset, String toCharset) throws Exception, IOException {
		/*
		 * BR--ISR--FIS--from
		 * PW--OSW--FOS--to
		 */
		BufferedReader in=
				new BufferedReader(
				new InputStreamReader(
				new FileInputStream(from),fromCharset));
		PrintWriter out=
				new PrintWriter(
				new OutputStreamWriter(
				new FileOutputStream(to),toCharset));
		String line;
		while((line =in.readLine())!=null){
			out.println(line);
		}
		out.close();
		in.close();
		
		
	}
}
