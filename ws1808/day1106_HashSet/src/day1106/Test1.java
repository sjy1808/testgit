package day1106;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		Set<Integer> set =new HashSet<>();
		set.add(123);
		set.add(456);
		set.add(454);
		set.add(789);
		set.add(4512);
		set.add(452);
		set.add(456);
		set.add(8972);
		set.add(124);
		System.out.println(set.size());
		System.out.println(set);
		System.out.println(set.remove(4512));
		System.out.println(set);
		//µü´úÆ÷±éÀú
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()){
			Integer s=it.next();
			System.out.println(s);
		}
		System.out.println("-------------");
		for(Iterator<Integer> it1=set.iterator();it1.hasNext();){
			Integer s1=it1.next();
			System.out.println(s1);
		}
	}
}
