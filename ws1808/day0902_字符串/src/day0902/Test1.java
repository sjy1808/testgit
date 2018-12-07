package day0902;

public class Test1 {
	public static void main(String[] args) {
		// 1.新建数组 2.新建String对象封装数组
		char[] a = { 'a', 'b', 'c' };
		String s1 = new String(a);//堆内存新分配内存空间
		String s2 = "abc";//常量池新分配内存空间
		String s3 = "abc";//访问常量池存在的对象

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s2);//比较内存地址
		System.out.println(s2 == s3);
		System.out.println(s1.equals(s2));//比较字符内容
	}
}
