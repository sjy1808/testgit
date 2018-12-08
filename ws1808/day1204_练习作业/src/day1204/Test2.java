package day1204;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		while (true) {
			try {
				f();
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("输入的是两个！");
			} catch (ArithmeticException e) {
				System.out.println("不能除零！");
			} catch (Exception e) {
				System.out.println("出错，请重试！");
			} finally {
				System.out.println("------------");
			}

		}
	}

	private static void f() {
		// TODO Auto-generated method stub
		System.out.println("输入逗号隔开的两个整数：");
		String s = new Scanner(System.in).nextLine();
		String[] a = s.split(",");
		int n1 = Integer.parseInt(a[0]);
		int n2 = Integer.parseInt(a[1]);
		int r = n1 / n2;
		System.out.println(r);
	}
}
