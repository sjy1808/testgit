package day1003;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) throws ParseException {
		System.out.println("生日(yyyy-MM-dd)：");
		String s = new Scanner(System.in).nextLine();
		// "2018-9-13"解析成Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 把字符串s解析成Date
		// ctrl+1,选择add throws...
		Date d = sdf.parse(s);
		long t = System.currentTimeMillis() - d.getTime();
		t = t / 1000 / 60 / 60 / 24;
		System.out.println("您已经生活了" + t + "天");
	}
}
