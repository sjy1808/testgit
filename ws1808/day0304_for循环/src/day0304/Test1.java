package day0304;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("\n\n--1��10---------");
		f1();
		System.out.println("\n\n--10��1---------");
		f2();
		System.out.println("\n\n--2,4,6,8,10---------");
		f3();
		System.out.println("\n\n--8,88,888,8888,..,888...888---------");
		f4();
		System.out.println("\n\n--��ѭ��---------");
		f5();
	}
	static void f1(){
		for(int i=1;i<=10;i++){
			System.out.println(i);
		}
	}
	static void f2(){
		for(int i=10;i>=1;i--){
			System.out.println(i);
		}
	}
	static void f3(){
		for(int i = 2;i<=10;i+=2){
			System.out.println(i);
		}
	}
	static void f4(){
		for(long i=8;i<=888888888;i=i*10+8){
			System.out.println(i);
		}
	}
	static void f5(){
		for(int i=1; ;i++){
			System.out.println(i);
		}
	}
}
