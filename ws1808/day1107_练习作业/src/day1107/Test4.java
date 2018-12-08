package day1107;

import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class Test4 {
	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put(4561, "唐伯虎");
		map.put(4534, "三分开啦");
		map.put(4523, "奋斗");
		map.put(4513, "大概是");
		map.put(4546, "下标");
		map.put(4565, "公司非国家");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(2));
		System.out.println(map.get(4523));
		System.out.println(map.remove(4523));
		System.out.println(map);
		System.out.println(map.remove(2));
	}
}
