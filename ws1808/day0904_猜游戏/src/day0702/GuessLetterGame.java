package day0702;

import java.security.InvalidParameterException;
import java.util.Random;

public class GuessLetterGame extends GuessGame {

	@Override
	public String suiji() {
		/*
		 * StringBuilder
		 * 
		 * "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		 */
		StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		for (int i = 0; i < 5; i++) {
			int j = new Random().nextInt(26);
			// i和j位置字符交换
			char t = sb.charAt(i);// 取i位置字符
			// 把i位置，设置成j位置的字符
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);// j位置设置成字符串

		}
		sb.delete(5, 26);
		System.out.println(sb);
		return sb.toString();
	}

	@Override
	public void tiShi() {
		System.out.println("已经产生了5个不重复的大写字母");
		System.out.println("请猜这5个字母");
	}

	@Override
	public String biJiao(String c, String r) {
		if(!c.matches("[A-Z]{5}")){
			throw new InvalidParameterException("五个大写字母，输入的是："+c);//非法参数异常
		}
		int a = 0, b = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; i < 5; j++) {
				if (c.charAt(i) == r.charAt(j)) {
					if (i == j) {
						a++;
					} else {
						b++;
					}
					break;
				}
			}
		}
		return a + "A" + b + "B";
	}

	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}

}
