package day1501;

import java.util.Arrays;

public class Test1 {
	static char[] a={'*','*','*','*','*','*'};
	static char c='-';
	public static void main(String[] args) {
		//启动两个线程
		startT1();
		startT2();
	}
	private static void startT1() {
		Thread t1=new Thread(){
			@Override
			public void run() {
				while(true){
					synchronized (a) {
						for(int i=0;i<a.length;i++){
							a[i]=c;
						}
					}
					c=(c=='*'?'-':'*');
				}
			}
		};//{}匿名类 继承Thread   创建线程对象
		t1.start();
	}
	private static void startT2() {
		new Thread(){
			@Override
			public void run() {
				while(true){
					synchronized (a) {
						System.out.println(Arrays.toString(a));
					}
				}
			}
		}.start();
	}
}
