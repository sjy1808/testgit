package day0901;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("�������ַ�����");
		String a = new Scanner(System.in).nextLine();
		System.out.println("������ҵ��Ӵ���");
		String b = new Scanner(System.in).nextLine();
		int[] s = find(a, b);
		System.out.println(Arrays.toString(s));

	}

	private static int[] find(String a, String b) {
		int[] s = new int[a.length()];
		int i = 0;
		int index = 0;
		while (true) {
			index = a.indexOf(b, index);
			if (index == -1)
				break;
			s[i] = index;
			i++;
			index++;

		}
		s = Arrays.copyOf(s, i);
		return s;

	}
}
