package day0307;

import java.math.BigInteger;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入一个整数求阶乘：");
		int n=new Scanner(System.in).nextInt();
		f(n);
	}
	static void f(int n){
		
		/*long r=n;
		for(int i=n-1;i>=1;i--){
			r*=i;
		}
		System.out.println(n+"的阶乘："+r);*/
		BigInteger r=BigInteger.valueOf(n);
		for(int i=n-1;i>=1;i--){
			r=r.multiply(BigInteger.valueOf(i));
		}
		String s=r.toString();
		System.out.println(s);
		/*for(long i=n-1;i>=1;i--){
			n*=i;
		}
		System.out.println(n);*/
	}
}

