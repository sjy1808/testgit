package day1202;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.println("����������������");
		double a=new Scanner(System.in).nextDouble();
		double b=new Scanner(System.in).nextDouble();
		try {
			double r=divide(a,b);
			System.out.println(r);
			
		} catch (Exception e) {
			System.out.println("���ܳ��㣬�����ǵĴ���������ǰɣ�");
			e.printStackTrace();//��ӡ�������쳣��Ϣ
		}
	}

	private static double divide(double a, double b) {
		if(b==0){
			ArithmeticException e = new ArithmeticException("/ by zero");
			throw e;//���쳣�����׵�����ĵ���λ��
		}
		return a/b;
	}
}
