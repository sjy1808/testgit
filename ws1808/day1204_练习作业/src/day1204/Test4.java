package day1204;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		// TODO Auto-generated method stub
		System.out.println("����������������");
		double d1 = new Scanner(System.in).nextDouble();
		double d2 = new Scanner(System.in).nextDouble();
		try {
			double r = divide(d1, d2);
			System.out.println(r);

		} catch (ArithmeticException e) {
			System.out.println("���ܳ�0�������ǵĴ���޲����ǰ�");
			e.printStackTrace();
		}

	}

	private static double divide(double d1, double d2) {
		if (d2 == 0) {
			ArithmeticException e = new ArithmeticException();
			throw e;
		}

		return d1 / d2;
	}
}
