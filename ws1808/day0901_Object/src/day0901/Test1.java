package day0901;

public class Test1 {
	public static void main(String[] args) {

		Point a = new Point(3, 4);
		Point b = new Point(3, 4);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a == b);
		System.out.println(a.equals(b));

		// equals()方法特殊参数值
		System.out.println("-------------");
		System.out.println(a.equals(null));
		System.out.println(a.equals(a));
		System.out.println(a.equals(67));
	}
}
