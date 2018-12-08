package day1102;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(111);
		list.add(222);
		list.add(3323);
		list.add(342);
		list.add(435);
		list.add(5467);
		list.add(567);
		list.add(678);
		list.add(8976);
		list.add(583);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.get(4));
		System.out.println(list.remove(5));
		System.out.println(list);
		System.out.println(list.remove(Integer.valueOf(5467)));
		System.out.println(list);
		// 下标遍历
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 迭代器遍历
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer n=it.next();
			System.out.println(n);
		}
	}
}
