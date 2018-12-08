package day0207;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("输入整数：");
		//先获得输入的值
		//再保存到变量n
		int n=new Scanner(System.in).nextInt();
		//调用f()方法
		//将n的值，传递到f()方法
		//进行计算
		f(n);
		
	}
	static void f(int a){
		//a右移动24,16,8,0,位，再强转成byte
		byte b1=(byte)(a>>24);
		byte b2=(byte)(a>>16);
		byte b3=(byte)(a>>8);
		byte b4=(byte)(a>>0);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		//byte值先左移动24（左侧的1顶出去）
		//再不带符号右移0,8,16,24,位
		//再与r求位或，结果存到r
		int r=0;
		r=r|(b1<<24>>>0);
		r=r|(b2<<24>>>8);
		r=r|(b3<<24>>>16);
		r=r|(b4<<24>>>24);
		
		System.out.println(r);
		
		r=0;
		//byte值和0x000000ff求位与
		//再左移24,16,8,0位，
		//再和r求位或，结果存到r
		r=r|((b1&0x000000ff)<<24);
		r=r|((b2&0x000000ff)<<16);
		r=r|((b3&0x000000ff)<<8);
		r=r|((b4&0x000000ff)<<0);
		
		System.out.println(r);
		
	}
}
