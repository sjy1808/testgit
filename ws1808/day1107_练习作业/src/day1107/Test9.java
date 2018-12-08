package day1107;

public class Test9 {
	public static void main(String[] args) {
		Integer a = new Integer(60);
		Integer b = Integer.valueOf(60);
		Integer c = Integer.valueOf(60);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println("-------------");
		System.out.println(a.byteValue());
		System.out.println(a.shortValue());
		System.out.println(a.intValue());
		System.out.println(a.longValue());
		System.out.println(a.floatValue());
		System.out.println(a.doubleValue());
		System.out.println("-------------");
		System.out.println(Integer.toBinaryString(245));
		System.out.println(Integer.toOctalString(245));
		System.out.println(Integer.toHexString(245));
		System.out.println(Integer.parseInt("245"));
		System.out.println("---------------");
		Double d1 = new Double(3.14);
		Double d2 = Double.valueOf(3.14);
		Double d3 = Double.valueOf(3.14);
		System.out.println(d1.hashCode(3.14));
		System.out.println(d1);
		System.out.println(d2.hashCode(3.14));
		System.out.println(d3.hashCode(3.14));
		System.out.println(d1==d2);
		System.out.println(d2==d3);
		System.out.println(d1);
		
	}
}
