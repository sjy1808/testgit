package day1202;

import java.io.PipedWriter;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.println("�û�����");
		String n = new Scanner(System.in).nextLine();
		System.out.println("���룺");
		String p = new Scanner(System.in).nextLine();

		try {
			login(n, p);
			System.out.println("��ӭ��¼");
		} catch (UsernameNotFoundException e) {
			System.out.println("�û�������");
		} catch (WrongPasswordException e) {
			System.out.println("�������");
		}
	}

	private static void login(String n, String p) throws UsernameNotFoundException, WrongPasswordException {
		// "abc" "123"
		if (!n.equals("abc")) {
			throw new UsernameNotFoundException();
		}
		if (!p.equals("123")) {
			throw new WrongPasswordException();
		}
	}
}
