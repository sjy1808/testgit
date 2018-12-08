package homework;

import java.util.Scanner;

public class Day03 {
	public static void main(String[] args) {
		System.out.println("请您输入您的工资：");
		double s=new Scanner(System.in).nextInt();
		double n=f(s);
		System.out.println("个人所得税："+n);
	}
	static double f(double s){
		if(s<3500){
			return 0;
		}
		s=s-3500;
		double r=0;
		int k=0;
		if(s<=1500){
			r=0.03;
			k=0;
		}else if(s<=4500){
			r=0.1;
			k=105;
		}else if(s<=9000){
			r=0.2;
			k=555;
		}else if(s<=35000){
			r=0.25;
			k=1005;
		}else if(s<=55000){
			r=0.3;
			k=2775;
		}else if(s<=80000){
			r=0.35;
			k=5505;
		}else {
			r=0.45;
			k=13505;
		}
		return  s*r-k;
	}
}
