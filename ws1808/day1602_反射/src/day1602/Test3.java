package day1602;

import java.lang.reflect.Field;

public class Test3 {
	public static void main(String[] args) throws Exception, Exception {
		//Integer的类对象
		Class<Integer> c=Integer.class;
		//Integer实例
		Integer a=Integer.valueOf(5);
		
		//获得value变量的值
		Field f=c.getDeclaredField("value");
		
		//使私有变量允许被访问
		f.setAccessible(true);
		//获得变量的值
		System.out.println(f.get(a));
		//设置变量的值
		f.set(a, 55);
		System.out.println(a.intValue());
		
	}
}
