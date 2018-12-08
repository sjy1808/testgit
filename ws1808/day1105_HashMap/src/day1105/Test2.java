package day1105;

import java.util.HashMap;

public class Test2 {
	public static void main(String[] args) {
		Point a = new Point(1, 3);
		Point b = new Point(1, 3);

		// 相同哈希值，才能保证计算出相同下标位置
		System.out.println(a.hashCode());// 父类Object的hashCode()方法
		System.out.println(b.hashCode());//内存地址

		// 即使哈希值相同，equals()也必须相等
		// 才能覆盖，否则链表连在一起
		System.out.println(a.equals(b));

		HashMap<Point, String> map = new HashMap<>();
		map.put(a, "3亿");
		map.put(b, "3.1亿");
		System.out.println(map);
	}
}
