package day0302;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//商品打折满500,9折
		//满1000,85折
		//满3000,8折
		//满5000,75折
		System.out.println("输入原价：");
		double price=new Scanner(System.in).nextInt();
		//price的值，传递到f()方法，求折扣价
		f(price);
	}
	static void f(double p){
		if(p<=0){
			System.out.println("原价错误！");
			//f（）方法到此结束
			//执行流程，返回到调用位置继续执行
			return;
		}
		//定义折扣比例，变量d，默认1
		double d=1;
		//根据原价p的范围来给d重新赋值
		if(p>=5000){
			d=0.7;
		}else if(p>=3000){
			d=0.8;
		}else if(p>=1000){
			d=0.85;
		}else if(p>=500){
			d=0.9;
		}
		
		//最后再求折扣价
		p=p*d;//p*=d;
		System.out.println("实际价格："+p);
	}
}
