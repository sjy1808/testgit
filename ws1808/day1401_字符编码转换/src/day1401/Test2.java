package day1401;

import java.io.UnsupportedEncodingException;

public class Test2 {
	public static void main(String[] args) throws Exception {
		byte[] a;
		
		a=new byte[]{97, 98, 99, -42, -48, -50, -60, -122, -76, -23, 70};
		f(a,null);
		
		a=new byte[]{97, 98, 99, -42, -48, -50, -60, -122, -76, -23, 70};
		f(a,"GBK");
		
		a=new byte[]{97, 98, 99, -42, -48, -50, -60, 63, 63};
		f(a,"GB2312");
		
		a=new byte[]{97, 98, 99, -28, -72, -83, -26, -106, -121, -27, -106, -122, -23, -107, -107};
		f(a,"UTF-8");
	}

	private static void f(byte[] a, String encoding) throws Exception {
		String  s;
		if(encoding==null){
			s=new String(a);//从系统默认编码，转成Unicode
		}else{
			s=new String(a,encoding);//从指定编码，转成Unicode
		}
		System.out.println(encoding+":"+s);
	}
}
