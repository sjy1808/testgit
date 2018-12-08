package day1204;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Test5 {
	public static void main(String[] args) {
		f();
	}

	private static void f() {
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list,"2018-9-17",
			       "2018-9-3",
			       "2018-9-20",
			       "2018-9-12",
			       "2018-9-21",
			       "fghfghfgherferter",
			       "2018-9-1",
			       "2018-9-10",
			       "2018-9-2");
		//Collections.sort(list);
		//System.out.println(list);
		 
			Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date d1 = sdf.parse(o1);
					Date d2 = sdf.parse(o2);
					return d1.compareTo(d2);
					
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		});
		System.out.println(list);
		
		
	}
}
