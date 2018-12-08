package day0905;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入身份证号：");
		String s = new Scanner(System.in).nextLine();

		// 正则表达式
		String regex = "\\d{15}|\\d{17}[\\dxX]";
		// 判断字符串s能否匹配正则表达式regex
		if (s.matches(regex)) {
			System.out.println("格式正确");
		} else {
			System.out.println("格式错误");
		}
	}
}
