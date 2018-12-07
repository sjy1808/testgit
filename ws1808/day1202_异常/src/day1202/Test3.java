package day1202;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.println("输入两个浮点数：");
		double a=new Scanner(System.in).nextDouble();
		double b=new Scanner(System.in).nextDouble();
		try {
			double r=divide(a,b);
			System.out.println(r);
			
		} catch (Exception e) {
			System.out.println("不能除零，是我们的错，请鞭笞我们吧！");
			e.printStackTrace();//打印完整的异常信息
		}
	}

	private static double divide(double a, double b) {
		if(b==0){
			ArithmeticException e = new ArithmeticException("/ by zero");
			throw e;//把异常对象抛到上面的调用位置
		}
		return a/b;
	}
}
