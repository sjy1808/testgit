package day0902;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		System.out.println("���룺");
		String s = new Scanner(System.in).nextLine();
		if (huiwen(s)) {
			System.out.println("�ǻ���");
		} else {
			System.out.println("���ǻ���");
		}
	}

	private static boolean huiwen(String s) {
		/*
		 * length(), charAt()
		 * 
		 * s="sffgffs" i j
		 * 
		 * 1.i,jѭ����������i<j 2.���i,jλ�õ��ַ������ 3.����false 4.ѭ�������󣬷���true
		 */
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
