package day1004;

import java.util.Iterator;
import java.util.LinkedList;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("�����������...");
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(1);
		}
		System.out.println("����׼����ϣ�");

		System.out.println("-----�±����-------");
		f1(list);

		System.out.println("-----��������-------");
		f2(list);
	}

	private static void f1(LinkedList<Integer> list) {
		long t = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		t = System.currentTimeMillis() - t;
		System.out.println(t);
	}

	private static void f2(LinkedList<Integer> list) {
		long t = System.currentTimeMillis();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			it.next();
		}
		t = System.currentTimeMillis() - t;
		System.out.println(t);
	}

}
