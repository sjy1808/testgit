package day0905;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("�������֤�ţ�");
		String s = new Scanner(System.in).nextLine();

		// ������ʽ
		String regex = "\\d{15}|\\d{17}[\\dxX]";
		// �ж��ַ���s�ܷ�ƥ��������ʽregex
		if (s.matches(regex)) {
			System.out.println("��ʽ��ȷ");
		} else {
			System.out.println("��ʽ����");
		}
	}
}
