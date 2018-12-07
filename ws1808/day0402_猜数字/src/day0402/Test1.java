package day0402;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//1+[0,1000)---->[1,1001)
		int r=1+new Random().nextInt(1000);
		System.out.println(r);
		
		System.out.println("已经产生了一个【1,1001）的随机整数");
		System.out.println("请猜这个数是几？");
		
		while(true){
			System.out.println("猜：");
			int c=new Scanner(System.in).nextInt();
			if(c>r){
				System.out.println("大");
			}else if(c<r){
				System.out.println("小");
			}else if(c==r){
				System.out.println("猜对了！");
				break;
			}
		}
	}
}
