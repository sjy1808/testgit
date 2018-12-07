package day1202;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		try {
			f();
		} catch (ParseException e) {
			System.out.println("���ڸ�ʽ����");
		} catch (IOException e) {
			System.out.println("�޷������ļ�");
		}
	}

	private static void f() throws ParseException, IOException {
		System.out.println("���գ�(yyyy-MM-dd)");
		String s = new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date d=sdf.parse(s);
		//"d:\456461223.txt"
		String path="d:\\"+d.getTime()+".txt";
		
		File f=new File(path);
		f.createNewFile();
	}
}
