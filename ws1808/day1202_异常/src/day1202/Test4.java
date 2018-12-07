package day1202;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.swing.text.SimpleAttributeSet;

public class Test4 {
	public static void main(String[] args) {
		f();
		//Exception
	}

	private static void f(){ 
		ArrayList<String> list = new ArrayList<>();
		Collections.addAll(list,"2018-09-15","2018-09-2","2018-09-20",//"2018-fzbzb",
				"2018-09-24","2018-09-18","2018-09-4","2018-09-30");
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1,String o2) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date d1=sdf.parse(o1);
					Date d2=sdf.parse(o2);
					return d1.compareTo(d2);
					
				} catch (Exception e) {
					//throw e;//异常不能抛出
					throw new RuntimeException(e);
				}
				
			}
		});//匿名内部类继承comparator接口
		System.out.println(list);
		
	}
}
