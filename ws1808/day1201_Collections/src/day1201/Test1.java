package day1201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		Collections.addAll(list, "45","12","7","23","25","18","5","33","51");
		
		//排序
		Collections.sort(list);//按字符顺序排序
		System.out.println(list);
		
		Comparator<String> c=new Comparator<String>(){
			/*
			 * o1和o2比较大小
			 * o1大，正数
			 * o1小，负数
			 * 相等，0
			 */
			@Override
			public int compare(String o1, String o2) {
				//o1,o2解析成int
				int a=Integer.parseInt(o1);
				int b=Integer.parseInt(o2);
				return a-b;
				
			}
		};//比较器子类对象，匿名类     抽象的接口（不能新建对象）
		//比较器对象，交给sort()方法使用，sort()方法内部会调用比较器的compare()方法
		Collections.sort(list,c);
		System.out.println(list);
		//for-each
		System.out.println("---------------");
		for (String string : list) {
			System.out.println(string);
			
		}
		System.out.println("-----------------");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
