package day1107;

import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<>();
		list.add(654);
		list.add(456);
		list.add("345");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(2));
		System.out.println(list.remove(2));
		System.out.println(list);
		list.add(789);
		list.add("234");
		System.out.println(list);
		System.out.println(list.remove(Integer.valueOf(789)));
		System.out.println(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		Iterator<Object> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
