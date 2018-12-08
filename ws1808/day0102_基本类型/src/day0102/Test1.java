package day0102;

public class Test1 {
	public static void main(String[] args){
		//定义8个变量abcdefgh
		//保存四种整数的最小值和最大值
		byte a=-128;
		byte b=127;
		//调用jdk基础类库中的Short类
		//调用Short类中的常量MIN_VALUE
		//获得short最小值
		short c=Short.MIN_VALUE;
		short d=Short.MAX_VALUE;
		int e=Integer.MIN_VALUE;
		int f=Integer.MAX_VALUE;
		long g=Long.MIN_VALUE;
		long h=Long.MAX_VALUE;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		/*
		 * System.out.println();
		 * System.out.println();
		 * System.out.println();
		 * System.out.println();*/
	}
}
