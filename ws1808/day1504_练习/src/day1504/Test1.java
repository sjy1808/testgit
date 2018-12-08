package day1504;

import java.util.Arrays;
public class Test1{
	static char[] a={'*','*','*','*','*','*'};
	static char c='-';
	public static void main(String[] args){
		startT1();
		startT2();
	} 
	private static void startT1(){
		new Thread(){
			@Override
			public void run(){
				while(true){
					synchronized(a){
						for(int i=0;i<a.length;i++){
							a[i]=c;
						}
					}
					c=c=='*'?'-':'*';
				}
			}
		}.start();
	}
	private static void startT2(){
		new Thread(){
			@Override
			public void run(){
				while(true){
					synchronized(a){
						System.out.println(Arrays.toString(a));
					}
				}
			}
		}.start();
	}
}