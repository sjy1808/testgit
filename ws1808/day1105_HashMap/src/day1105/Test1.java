package day1105;

import java.util.HashMap;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("输入：");
		String s = new Scanner(System.in).nextLine();

		// 新建HashMap
		HashMap<Character, Integer> map = new HashMap<>();
		// 遍历字符串s
		for (int i = 0; i < s.length(); i++) {
			// 取出i位置字符
			char c = s.charAt(i);
			// 从map获取c对应的计数值
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
