package day0403;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("\n\n-------------");
		f1();
		System.out.println("\n\n-------------");
		f2();
		System.out.println("\n\n-------------");
		f3();
		System.out.println("\n\n-------------");
		f4();
		System.out.println("\n\n-------------");
		f5();
	}
	static void f1(){
		//新建5个长度的int[]数组
		//再把它的内存地址保存到变量a
		int[] a=new int[5];
		//Arrays.toString(a)
		//作用：把数组中的数据，连接成字符串[值1，值2，值3......]
		System.out.println(Arrays.toString(a));
		System.out.println(a);//打印的是a数组的内存地址
	}
	static void f2(){
		char[] a={'a','b','c'};
		System.out.println(Arrays.toString(a));
		System.out.println(a);
		
	}
	static void f3(){
		boolean[] a;
		a=new boolean[]{true,false,true,false};
		System.out.println(Arrays.toString(a));
		System.out.println(a[2]);
		
	}
	static void f4(){
		//新建10个长度的int[]数组
		//地址保存到变量a 
		int[] a=new int[10];
		//遍历访问每个位置
		//在每个位置放入100内随机整数
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
			//a[i]=(int)Math.random()*100;
			System.out.println(a[i]);
		}
		//打印
		System.out.println(Arrays.toString(a));
	}
	static void f5(){
		//交换数组中下标2,3两个位置的值
		int[] a={5,4,54,6,51,51,51,46};
		//            2 3
		
		int t=a[2];
		a[2]=a[3];
		a[3]=t;
		System.out.println(Arrays.toString(a));
	}
}
