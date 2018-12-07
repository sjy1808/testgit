package day1004;

import java.util.Iterator;
import java.util.LinkedList;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * <>泛型 用来限制集合中存放的数据类型 泛型语法不支持基本类型 集合不允许 存放基本类型，得用包装类类型
		 */
		LinkedList<String> list = new LinkedList<>();
		list.add("qqq");
		list.add("sss");
		list.add("www");
		list.add("xxxx");
		list.add("xd");
		list.add("dfg");
		list.add("cvcxz");
		list.add("sss");
		list.add("ddd");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.remove(3));
		System.out.println(list);
		System.out.println(list.remove("xxxx"));
		System.out.println(list);
		System.out.println("------------------");
		// 双向链表，下标遍历，效率低
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------");
		// 迭代遍历
		// 新建迭代器对象
		Iterator<String> it = list.iterator();
		// 当有数据
		while (it.hasNext()) {
			// 取下一项数据
			String s = it.next();
			System.out.println(s);
		}
	}
}
