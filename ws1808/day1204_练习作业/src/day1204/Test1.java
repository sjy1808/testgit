package day1204;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list,"3","11","2","21","10","32",
			       "1","31","20","30","12","22");
		Collections.sort(list);
		System.out.println(list);
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int a=Integer.parseInt(o1);
				int b=Integer.parseInt(o2);
				return a-b;
			}
		};
		Collections.sort(list,c);
		System.out.println(list);
	}
	
}
