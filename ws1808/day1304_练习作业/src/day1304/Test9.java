package day1304;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		System.out.println("�����ļ��У�");
		String s = new Scanner(System.in).nextLine();
		
		File from = new File(s);
		if(!from.isDirectory()){
			System.out.println("�����ļ���");
			return;
		}
		System.out.println("����Ŀ���ļ���");
		String s1 = new Scanner(System.in).nextLine();
		File to=new File(s1);
		if(to.isFile()){
			System.out.println("�������ļ�");
			return;
		}
		try {
			copy(from,to);
			System.out.println("�������");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		
	}

	private static void copy(File from, File to) throws Exception {
		if(!to.mkdir())return;
		File[] files = from.listFiles();
		if(files==null)return;
		
		for(File f:files){
			if(f.isFile()){
				FileInputStream in = new FileInputStream(f);
				FileOutputStream out = new FileOutputStream(new File(to,f.getName()));
				byte[] buff=new byte[8192];
				int n;
				while((n=in.read(buff))!=-1){
					out.write(buff,0,n);
				}
				in.close();
				out.close();
			}else{
				copy(f,new File(to,f.getName()));
			}
		}
	}
}
