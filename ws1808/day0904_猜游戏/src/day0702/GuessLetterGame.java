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
			// i��jλ���ַ�����
			char t = sb.charAt(i);// ȡiλ���ַ�
			// ��iλ�ã����ó�jλ�õ��ַ�
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, t);// jλ�����ó��ַ���

		}
		sb.delete(5, 26);
		System.out.println(sb);
		return sb.toString();
	}

	@Override
	public void tiShi() {
		System.out.println("�Ѿ�������5�����ظ��Ĵ�д��ĸ");
		System.out.println("�����5����ĸ");
	}

	@Override
	public String biJiao(String c, String r) {
		if(!c.matches("[A-Z]{5}")){
			throw new InvalidParameterException("�����д��ĸ��������ǣ�"+c);//�Ƿ������쳣
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
