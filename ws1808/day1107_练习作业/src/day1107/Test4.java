package day1107;

import java.util.HashMap;

import javax.print.attribute.HashAttributeSet;

public class Test4 {
	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<>();
		map.put(4561, "�Ʋ���");
		map.put(4534, "���ֿ���");
		map.put(4523, "�ܶ�");
		map.put(4513, "�����");
		map.put(4546, "�±�");
		map.put(4565, "��˾�ǹ���");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(2));
		System.out.println(map.get(4523));
		System.out.println(map.remove(4523));
		System.out.println(map);
		System.out.println(map.remove(2));
	}
}
