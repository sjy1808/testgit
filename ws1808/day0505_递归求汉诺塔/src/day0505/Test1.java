package day0505;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("�漸�㺺ŵ����");
		int n=new Scanner(System.in).nextInt();
		f(n,"A","B","C");
	}

	private static void f(int n, 
			String z1, 
			String z2, 
			String z3) {
		if(n==1){
			System.out.println(z1+"->"+z3);
			return;
		}
		//�򻯳�����n-1�㣬��z1������z3����z2
		f(n-1,z1,z3,z2);
		//�����һ�㣬��z1��z3
		System.out.println(z1+"->"+z3);
		//��z2�ϵ�n-1�㣬��z2,��z1����z3
		f(n-1,z2,z1,z3);
		
	}
}
