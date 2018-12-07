package day0301;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入三个整数：");
		int a=new Scanner(System.in).nextInt();
		int b=new Scanner(System.in).nextInt();
		int c=new Scanner(System.in).nextInt();
		
		//取ab的最大值，保存到变量max
		//取max，c的最大值，保存到变量max
		//int max=a>b?a:b;
		//max=max>c?max:c;
		
		//三项运算的嵌套
		int max=a>b?(a>c?a:c):(b>c?b:c);
		System.out.println("最大值是："+max);
		
	}
}
