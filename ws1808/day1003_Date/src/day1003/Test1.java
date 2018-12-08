package day1003;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		Date a = new Date();
		Date b = new Date(612042310L);
		System.out.println(a);
		System.out.println(b);

		System.out.println(a.getTime());
		System.out.println(b.getTime());

		a.setTime(0);
		System.out.println(a);

		System.out.println("---------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		//Date对象格式化成字符串
		String s1 = sdf.format(a);
		String s2 = sdf.format(b);
		System.out.println(s1);
		System.out.println(s2);
	}
}
