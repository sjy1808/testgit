package day1302;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("����Դ�ļ���");
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
		try {
			copy(from,to);
			System.out.println("�������");
		} catch (Exception e) {
			System.out.println("����ʧ��");
			e.printStackTrace();//��ӡ�쳣������ͨ�û�û��
		}
	}

	private static void copy(File from, File to) throws Exception{
		/*
		 * ����from��ԭ�ļ�
		 * ����to��Ŀ���ļ�
		 * 
		 * ������
		 * FIS---from
		 * FOS---to
		 * 
		 * ���ֽ�ѭ����ȡ����׼��ʽ
		 * ��ȡ��һ���ֽ�ֵ������������
		 * 
		 * �ر�������
		 */
		/*FileInputStream in = new FileInputStream(from);
		FileOutputStream out = new FileOutputStream(to);*/
		//�߼���,��ߵ��ֽڶ�дЧ��
		BufferedInputStream in=new BufferedInputStream( 
				new FileInputStream(from));
		BufferedOutputStream out=new BufferedOutputStream( 
				new FileOutputStream(to));
		
		int b;//���ֽڶ�д
		while((b=in.read())!=-1){
			out.write(b);
		}
		
		
		//������д
		//����ĳ���һ����8192,8K
		/*byte[] buff=new byte[8192];
		int n;//��������ÿһ��������
		while((n=in.read(buff))!=-1){
			out.write(buff,0,n);
			//out.write(buff);
		}*/
		in.close();
		out.close();
	}
}
