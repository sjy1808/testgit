package day0304;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("\n\n--------------");
		f1();
		System.out.println("\n\n--------------");
		f2();
		System.out.println("\n\n--------------");
		f3();
		
	}
	static void f3(){
		//显示三角形*
		System.out.println("行数：");
		int n=new Scanner(System.in).nextInt();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void f2(){
		//显示一个正方形*
		System.out.println("行数：");
		int n=new Scanner(System.in).nextInt();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				System.out.print("*");
			}
			//补换行
			System.out.println();
		}
	}
	static void f1(){
		for(int i=1;i<=3;i++){
			for(char j='a';j<='c';j++){
				System.out.println(i+","+j);
			}
		}
	}
}
