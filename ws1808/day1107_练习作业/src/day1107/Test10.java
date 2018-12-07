package day1107;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		System.out.println("输入两个浮点数：");
		double a=new Scanner(System.in).nextDouble();
		double b=new Scanner(System.in).nextDouble();
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println("--------------");
		BigDecimal bd1 = BigDecimal.valueOf(a);
		BigDecimal bd2 = BigDecimal.valueOf(b);
		BigDecimal bd3;
		bd3=bd1.add(bd2);
		System.out.println(bd3);
		bd3=bd1.subtract(bd2);
		System.out.println(bd3);
		bd3=bd1.multiply(bd2);
		System.out.println(bd3);
		bd3=bd1.divide(bd2,12,BigDecimal.ROUND_HALF_UP);
		System.out.println(bd3);
		System.out.println(bd3.doubleValue());
		System.out.println(bd3.toString());
		Date t = new Date();
		System.out.println(t);
		System.out.println(t.getTime());
		t.setTime(1201231);
		System.out.println(t);
		System.out.println("------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String s1=sdf.format(t);
		System.out.println(t);
		long t1=System.currentTimeMillis();
		System.out.println(t1);
		
		
	}
}
