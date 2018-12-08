package day1107;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test11 {
	public static void main(String[] args) throws ParseException {
		System.out.println("输入你的生日(yyyy.MM.dd):");
		String s = new Scanner(System.in).nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date d=sdf.parse(s);
		long t=System.currentTimeMillis()-d.getTime();
		t=t/1000/60/60/24;
		System.out.println("生存了"+t+"天");
	}
}
