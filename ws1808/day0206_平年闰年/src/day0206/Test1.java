package day0206;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("年号：");
		//先获得输入的值
		//再保存到变量y
		int y=new Scanner(System.in).nextInt();
		
		//调用f()方法
		//把y的值传递到f()方法进行运算
		f(y);
		
	}
	static void f(int year){
		//定义字符串变量，默认是"平年"
		//如果后面判断是闰年，再把r的值修改成闰年
		String r="平年";
		//year 变量的值，能否被4整除
		/*if(year%4==0){
			//能被4整除的情况下
			//再判断，不能被100整除
			if(year%100!=0){
				r="闰年";
			}
		}
		
		//如果year能被400整除
		if(year%400==0){
			r="闰年";
		}*/
		//如果能被4整除，并且不能被100整除
		//或者，能被400整除
		if((year%4==0&&year%100!=0)||year%400==0){
			r="闰年";
			
		}
		System.out.println(year+"年是"+r);
	}
}
