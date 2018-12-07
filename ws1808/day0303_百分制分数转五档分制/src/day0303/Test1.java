package day0303;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		/*
		 *百分制分数，转成五档分制
		A  [90,100]
		B  [70,90)
		C  [60,70)
		D  [20,60)
		E  [0,20) */
		System.out.println("百分制分数：");
		int s=new Scanner(System.in).nextInt();
		//调用方法f()
		//把s色值传递到f()方法进行计算
		f(s);
	}
	static void f(int score){
		if(score<0||score>100){
			System.out.println("分数不正确");
			//f()方法到此结束
			//返回到调用位置继续
			return;
		}
		//定义一个变量来保存结果，默认值0
		char r=0;
		//根据score，给r赋值
		switch(score/10){
		case 10:
		case 9:
			r='A';
			break;
		case 8:
		case 7:
			r='B';
			break;
		case 6:
			r='C';
			break;
		case 5:
		case 4:
		case 3:
		case 2:
			r='D';
			break;
		case 1:
		case 0:
			r='E';
			break;
			
		}
		System.out.println("五档分制是："+r);
	}
}
