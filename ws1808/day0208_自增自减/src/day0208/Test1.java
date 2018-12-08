package day0208;

public class Test1 {
	public static void main(String[] args) {
		int a;
		a=5;
		System.out.println(a++);
		a=5;
		System.out.println(++a);
		a=5;
		int b=a++;
		System.out.println(a);
		System.out.println(b);
		
		a=5;
		a=a++;//1.取5   2.  a变成6   3.原值5又赋给a
		System.out.println(a);
		
	}
}
