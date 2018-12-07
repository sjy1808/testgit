package day0804;

import day0804.A.Inner1;
import day0804.A.Inner2;

public class Test1 {
	public static void main(String[] args) {
		Inner1 i1=new Inner1();
		System.out.println(i1);
		A.Inner1 i2=new Inner1();
		System.out.println(i2);
		
		A a=new A();
		Inner2 i3=a.new Inner2();
		System.out.println(i3);
	}
}

class A {
	static class Inner1 {

	}

	class Inner2 {

	}
}