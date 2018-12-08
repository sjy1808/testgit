package day0505;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("玩几层汉诺塔：");
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
		//简化成上面n-1层，从z1，经过z3，到z2
		f(n-1,z1,z3,z2);
		//最底下一层，从z1到z3
		System.out.println(z1+"->"+z3);
		//在z2上的n-1层，从z2,经z1，到z3
		f(n-1,z2,z1,z3);
		
	}
}
