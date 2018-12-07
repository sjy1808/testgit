package day1401;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//Unicode
		String s="abc���Ć��F";
		System.out.println(s);
		
		f(s,null);
		f(s,"GBK");
		f(s,"GB2312");
		f(s,"UTF-8");
		
	}
	/*
	 * �ַ�����encoding
	 * �ַ���charset
	 */
	private static void f(String s, String encoding) throws Exception {
		byte[] a;
		
		if(encoding==null){
			a=s.getBytes();//ת��ϵͳĬ�ϱ���
		}else{
			a=s.getBytes(encoding);//ת��ָ���ı���
		}
		System.out.println(encoding+"\t"+Arrays.toString(a));
	}
}
