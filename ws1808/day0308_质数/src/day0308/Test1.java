package day0308;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入一个整数n，求n内质数的数量:");
		int n=new Scanner(System.in).nextInt();
		//调用f()方法
		//把n的值传递到f()方法进行计算
		//再把得到的f()方法的返回值，保存到变量r
		int r=f(n);
		System.out.println(r);
		
	}
	static int f(int n){
		//n<2不用找质数，没有质数
		if(n<2){
			return 0;
		}
		//已知2是质数，已经有一个质数
		//定义一个计数变量
		int count=1;
		
		//在3到n范围内寻找质数
		outer:
		for(int i=3;i<=n;i++){
			//i的值是否是质数
			double max=Math.sqrt(i)+1;
			//在2到<max范围内，找能把i整除的值
			for(int j=2;j<max;j++){
				//如果i能被j整除
				if(i%j==0){
					continue outer;
				}
			}
			//i是质数，计数增加
			count++;
		}
		return count;
	}
}
