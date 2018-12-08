package day1203;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		String path;
		
		path = "D:\\金山打字通\\Typeeasy\\TypeEasy.exe";//存在的文件路径
		//path = "D:\\金山打字通\\Typeeasy";//存在的目录路径
		//path = "x:\\dfs\\sd";//不存在的路径
		
		File f = new File(path);
		System.out.println(f.exists());//是否存在
		System.out.println(f.isFile());//是否是文件
		System.out.println(f.isDirectory());//是否是文件夹
		System.out.println(f.getName());//文件名
		System.out.println(f.getParent());//父文件夹
		System.out.println(f.length());//文件大小
		System.out.println(f.lastModified());//最后修改时间
		long t=f.lastModified();
		Date d=new Date(t);
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s1=sdf.format(d);
		System.out.println(s1);
	}
}
