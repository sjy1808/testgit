package day1105;

import java.util.HashMap;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("���룺");
		String s = new Scanner(System.in).nextLine();

		// �½�HashMap
		HashMap<Character, Integer> map = new HashMap<>();
		// �����ַ���s
		for (int i = 0; i < s.length(); i++) {
			// ȡ��iλ���ַ�
			char c = s.charAt(i);
			// ��map��ȡc��Ӧ�ļ���ֵ
			Integer count = map.get(c);
			if (count == null) {
				map.put(c, 1);
			} else {
				map.put(c, count + 1);
			}
		}
		System.out.println(map);
	}
}
