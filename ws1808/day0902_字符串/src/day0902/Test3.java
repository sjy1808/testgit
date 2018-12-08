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

		// 从参数e，查找"@"符号的下标位置
		// 保存到变量i
		// 如果没有找到@符号，直接返回"错误格式"
		// 截取[0,i)子串，直接返回
		int i = e.indexOf("@");
		if (i == -1) {
			return "错误格式";
		}
		return e.substring(0, i);

	}
}
