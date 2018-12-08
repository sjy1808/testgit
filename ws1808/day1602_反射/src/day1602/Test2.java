package day1602;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws Exception {
		System.out.println("输入类名：");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		
		Object o1=null;
		Object o2=null;
		
		try {
			o1=c.newInstance();
		} catch (Exception e) {
			System.out.println("无参构造方法执行失败");
		}
		try {
			//调用int参数构造方法
			Constructor<?> t = c.getConstructor(int.class);
			o2=t.newInstance(100);
		} catch (Exception e) {
			System.out.println("不能执行int参数构造方法");
		}
		System.out.println("---------");
		System.out.println("o1:"+o1);
		System.out.println("o2:"+o2);
	}
}
