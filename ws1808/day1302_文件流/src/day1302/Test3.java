package day1302;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("输入源文件：");
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
		try {
			copy(from,to);
			System.out.println("复制完成");
		} catch (Exception e) {
			System.out.println("复制失败");
			e.printStackTrace();//打印异常，对普通用户没用
		}
	}

	private static void copy(File from, File to) throws Exception{
		/*
		 * 参数from：原文件
		 * 参数to：目标文件
		 * 
		 * 创建流
		 * FIS---from
		 * FOS---to
		 * 
		 * 单字节循环读取，标准格式
		 * 读取的一个字节值，向输出流输出
		 * 
		 * 关闭两个流
		 */
		/*FileInputStream in = new FileInputStream(from);
		FileOutputStream out = new FileOutputStream(to);*/
		//高级流,提高单字节读写效率
		BufferedInputStream in=new BufferedInputStream( 
				new FileInputStream(from));
		BufferedOutputStream out=new BufferedOutputStream( 
				new FileOutputStream(to));
		
		int b;//单字节读写
		while((b=in.read())!=-1){
			out.write(b);
		}
		
		
		//批量读写
		//数组的长度一般用8192,8K
		/*byte[] buff=new byte[8192];
		int n;//用来保存每一批的数量
		while((n=in.read(buff))!=-1){
			out.write(buff,0,n);
			//out.write(buff);
		}*/
		in.close();
		out.close();
	}
}
