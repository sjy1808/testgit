package day1204;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		System.out.println("用户名：");
		String s = new Scanner(System.in).nextLine();
		System.out.println("密码：");
		String d = new Scanner(System.in).nextLine();
		try {
			login(s,d);
			System.out.println("欢迎登录！");
		} catch (UsernameNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("用户名错误");
		} catch (WrongPasswordException e) {
			// TODO Auto-generated catch block
			System.out.println("密码错误");
		}
		
	}

	private static void login(String s, String d) throws UsernameNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		if(!"abc".equals(s)){
			throw new UsernameNotFoundException();
		}
		if(!"123".equals(d)){
			throw new WrongPasswordException();
		}
	}
}
