package day1404;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		t1.start();
		//main线程，打断t1线程
		System.out.println("按回车");
		new Scanner(System.in).nextLine();
		t1.interrupt();
	}
	static class T1 extends Thread {
		long base=0;
		@Override
		public void run() {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm：ss.SSS");
			while(true){
				Date d = new Date();
				String s=sdf.format(d);
				System.out.println(s);
				long dt=(d.getTime()-base)%1000;
				try {
					Thread.sleep(1000-dt);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("谁TMD捅醒了老子");
				}
			}
		}
	}
}
