package day0103;
//导包，指明一个类的路径，后面可以简写类名
import java.util.Scanner;
public class Test1 {
	public static void main(String[] args){
		System.out.print("输入整数a:");
		//先获得输入的值
		//再保存到变量a
		int a=new Scanner(System.in).nextInt();
		System.out.print("输入整数b:");
		int b=new Scanner(System.in).nextInt();
		int c=a;
		a=b;
		b=c;
		System.out.println("a="+a);
		System.out.println("b="+b);
		
	}
}
