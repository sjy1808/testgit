package day0504;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("��ڼ���쳲���������");
		int n=new Scanner(System.in).nextInt();
		long r=g(n);
		System.out.println(r);
	}

	private static long g(int n) {
		/*
		 * 1  1  2  3  5
		 * a     b
		 * b=a+b
		 * a=b-a*/
		long a=1;
		long b=1;
		//�ӵ������󵽵�n��
		for(int i=3;i<=n;i++){
			b=a+b;
			a=b-a;
		}
		return b;
	}

	private static long f(int n) {
		//�������
		if(n==1||n==2){
			return 1;
		}
		return f(n-1)+f(n-2);
	}
}
