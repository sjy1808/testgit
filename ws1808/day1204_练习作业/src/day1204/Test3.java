package day1204;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		try {
			f();
			
		} catch (ParseException e) {
			System.out.println("���ڸ�ʽ����");
		}catch(IOException e){
			System.out.println("�޷������ļ�");
		}
	}

	private static void f() throws ParseException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�����������(yyyy-MM-dd):");
		String s = new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date d=sdf.parse(s);
		String path="s:\\"+d.getTime()+".txt";
		File f=new File(path);
		f.createNewFile();
		
	}
}
