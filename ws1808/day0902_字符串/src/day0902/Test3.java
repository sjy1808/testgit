package day0902;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("email:");
		String e = new Scanner(System.in).nextLine();
		String n = getName(e);
		System.out.println(n);
	}

	private static String getName(String e) {
		// sfkfj@sjfk.com
		// indexOf(), substring()

		// �Ӳ���e������"@"���ŵ��±�λ��
		// ���浽����i
		// ���û���ҵ�@���ţ�ֱ�ӷ���"�����ʽ"
		// ��ȡ[0,i)�Ӵ���ֱ�ӷ���
		int i = e.indexOf("@");
		if (i == -1) {
			return "�����ʽ";
		}
		return e.substring(0, i);

	}
}
