package day1203;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		String path;
		
		path = "D:\\��ɽ����ͨ\\Typeeasy\\TypeEasy.exe";//���ڵ��ļ�·��
		//path = "D:\\��ɽ����ͨ\\Typeeasy";//���ڵ�Ŀ¼·��
		//path = "x:\\dfs\\sd";//�����ڵ�·��
		
		File f = new File(path);
		System.out.println(f.exists());//�Ƿ����
		System.out.println(f.isFile());//�Ƿ����ļ�
		System.out.println(f.isDirectory());//�Ƿ����ļ���
		System.out.println(f.getName());//�ļ���
		System.out.println(f.getParent());//���ļ���
		System.out.println(f.length());//�ļ���С
		System.out.println(f.lastModified());//����޸�ʱ��
		long t=f.lastModified();
		Date d=new Date(t);
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s1=sdf.format(d);
		System.out.println(s1);
	}
}
