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
		a=a++;//1.ȡ5   2.  a���6   3.ԭֵ5�ָ���a
		System.out.println(a);
		
	}
}
