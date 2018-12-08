package practice;

import java.util.Scanner;

public class Test0202{
	public static void main(String[] args){
		System.out.println("输入三个整数：");
		int a=new Scanner(System.in).nextInt();
		int b=new Scanner(System.in).nextInt();
		int c=new Scanner(System.in).nextInt();
		int max=f(a,b,c);
		System.out.println(max);
	}
	static int f(int a,int b,int c){
		int m=a>b?(a>c?a:c):(b>c?b:c);
		return m;
	}
}