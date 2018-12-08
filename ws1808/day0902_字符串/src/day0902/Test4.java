package day0902;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		System.out.println("输入：");
		String s = new Scanner(System.in).nextLine();
		if (huiwen(s)) {
			System.out.println("是回文");
		} else {
			System.out.println("不是回文");
		}
	}

	private static boolean huiwen(String s) {
		/*
		 * length(), charAt()
		 * 
		 * s="sffgffs" i j
		 * 
		 * 1.i,j循环，条件是i<j 2.如果i,j位置的字符不相等 3.返回false 4.循环结束后，返回true
		 */
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
