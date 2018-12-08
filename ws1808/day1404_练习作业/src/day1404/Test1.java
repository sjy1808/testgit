package day1404;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) throws Exception {
		String s="abcÖÐÎÄ†´éFÉÏ¿Î";
		System.out.println(s);
		f(s,null);
		f(s,"GBK");
		f(s,"UTF-8");
		f(s,"GB2312");
	}

	private static void f(String s, String encoding) throws Exception {
		// TODO Auto-generated method stub
		byte[] a;
		if(encoding==null){
			a=s.getBytes();
		}else{
			a=s.getBytes(encoding);
		}
		System.out.println(encoding+"\t"+Arrays.toString(a));
		
	}
}
