package day0905;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("����̶��绰���룺");
		String s = new Scanner(System.in).nextLine();
		/*
		 * 1234567
		 * 12345678
		 * 010-1234567
		 * 0120-12345678
		 * (010)-1234567
		 * (0120)-12345678
		 * 
		 *\d{7,8}
		 *(����)?\d{7,8}
		 *(|)?\d{7,8}
		 *(\d{3,4}-|)?\d{7,8}
		 *(\d{3,4}-|())?\d{7,8}
		 *(\d{3,4}-|\(\))?\d{7,8}
		 *(\d{3,4}-|\(\d{3,4}\))?\d{7,8}
		 *(\\d{3,4}-|\\(\\d{3,4}\\))?\\d{7,8}
		 * 
		 */
		// ������ʽ
		String regex = "(\\d{3,4}-|\\(\\d{3,4}\\)-)?\\d{7,8}";
		// �ж��ַ���s�ܷ�ƥ��������ʽregex
		if (s.matches(regex)) {
			System.out.println("��ʽ��ȷ");
		} else {
			System.out.println("��ʽ����");
		}
	}
}
