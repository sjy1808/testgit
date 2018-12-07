package day0602;

public class Test1 {
	public static void main(String[] args) {
		//新建Point对象，3,4点，存到变量p1
		Point a=new Point(3,4);
		//调用p1点的toString()方法
		//并打印这个方法的返回值
		String b=a.toString();
		System.out.println(b);
		System.out.println(a.toString());
		//调用p1点的distance()方法
		//并打印这个方法的返回值
		double c=a.distance();
		System.out.println(c);
		System.out.println(a.distance());
	}
}
