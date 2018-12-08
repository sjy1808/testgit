package day1301;

import java.io.File;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("�����ļ��У�");
		String s = new Scanner(System.in).nextLine();
		File dir=new File(s);
		if(!dir.isDirectory()){
			System.out.println("�����ļ���");
			return;
		}
		
		long size = dirLength(dir);
		System.out.println(size);
		
	}

	private static long dirLength(File dir) {
		File[] files=dir.listFiles();
		if(files==null){
			return 0;
		}
		long sum=0;
		for(File f:files){
			if(f.isFile()){//f���ļ�
				sum+=f.length();
			}else{//f���ļ���
				sum+=dirLength(f);//�ݹ���f�ļ��еĴ�С
			}
		}
		return sum;
		
	}
}
