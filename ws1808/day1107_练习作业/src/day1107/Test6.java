package day1107;

import java.util.HashMap;

public class Test6 {
	public static void main(String[] args) {
		Point a = new Point(1,3);
		Point b = new Point(1,3);
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
		HashMap<Point,String> map = new HashMap<>();
		map.put(a, "300million");
		map.put(b, "310million");
		System.out.println(map);
		
		
	}
}
