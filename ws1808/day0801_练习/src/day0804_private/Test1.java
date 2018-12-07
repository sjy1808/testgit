package day0804_private;

import day0804_private.A.Inner1;
import day0804_private.A.Inner2;

public class Test1 {
	public static void main(String[] args) {
		Inner1 i1 = new Inner1();
		System.out.println(i1);

		A a = new A();
		Inner2 i2 = a.new Inner2();
		System.out.println(i2);
	}
}

class A {
	static class Inner1 {
	}

	class Inner2 {
	}
}
