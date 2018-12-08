package day0205;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(1);
		//调用f()方法
		//再得到f()方法的返回值，保存到变量r1
		int r1=f(2);
		System.out.println(r1);
		
		System.out.println(2);
		int r2=f(3);
		System.out.println(r2);
	}
	static int f(int a){
		return a*a;
	}
}
