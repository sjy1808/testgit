package day0305;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入整数：");
		int n=new Scanner(System.in).nextInt();
		//调用f()方法
		//把n的值传递到f()方法进行计算
		f(n);
	}
	static void f(int n){
		if(n==2){
			System.out.println("2是质数");
			return;
		}
		//判断n的值是否是质数
		//在2到1+根号n 范围内找能把n整除的数
		
		//求1+根号n的值，存到变量max
		double max=1+Math.sqrt(n);
		//循环2到<max
		
		for(int i=2;i<max;i++){
			//判断如果n被i整除
			if(n%i==0){
				//n不是质数
				System.out.println(n+"不是质数");
				//方法到此结束
				//返回到调用位置继续执行
				return;
			}
		}
		System.out.println(n+"是质数");
		
	}
}
