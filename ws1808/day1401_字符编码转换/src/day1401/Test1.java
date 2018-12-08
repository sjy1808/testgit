package day1401;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//Unicode
		String s="abc中文喆镕";
		System.out.println(s);
		
		f(s,null);
		f(s,"GBK");
		f(s,"GB2312");
		f(s,"UTF-8");
		
	}
	/*
	 * 字符编码encoding
	 * 字符集charset
	 */
	private static void f(String s, String encoding) throws Exception {
		byte[] a;
		
		if(encoding==null){
			a=s.getBytes();//转成系统默认编码
		}else{
			a=s.getBytes(encoding);//转成指定的编码
		}
		System.out.println(encoding+"\t"+Arrays.toString(a));
	}
}
