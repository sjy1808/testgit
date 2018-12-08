package day1107;

import java.util.Iterator;
import java.util.LinkedList;

public class Test12 {
	public static void main(String[] args) {
		LinkedList<Object> list = new LinkedList<>();
		list.add("sjdk");
		list.add("ccc");
		list.add("uuu");
		list.add("ppp");
		list.add("qqq");
		list.add("ccc");
		list.add("aaa1");
		list.add("aaa");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(list.size()-1));
		System.out.println(list.remove(3));
		System.out.println(list);
		System.out.println(list.remove("asd"));
		System.out.println(list.remove("ccc"));
		System.out.println(list);
		System.out.println("----------------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("----------------");
		Iterator<Object> it = list.iterator();
		while(it.hasNext()){
			Object s=it.next();
			System.out.println(s);
		}
	}
}
