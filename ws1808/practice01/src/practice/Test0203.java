package practice;

import java.util.Scanner;

public class Test0203{
	public static void main(String[] args) {
		System.out.println("输入整数n,求n内质数数量：");
		int n=new Scanner(System.in).nextInt();
		int r=f(n);
		System.out.println(r);
	}
	static int f(int n){
		if(n<2){
			return 0;
		}
		int count=1;
		outer:
		for(int i=3;i<n;i++){
			double max=1+Math.sqrt(i);
			for(int j=2;j<max;j++){
				if(i%j==0){
					continue outer;
				}
			}
			count++;
			
		}
		return count;
	}
}
