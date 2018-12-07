package day0602;

public class Test2 {
	public static void main(String[] args) {
		Point3D p=new Point3D(3,4,5);
		System.out.println(p.distance());
		System.out.println(p.toString());
		
		Point p2= new Point(3,4);
		
		f(p);//Point3D向上转型成Point传递到f()方法
		f(p2);
	}
	public static void f(Point p){
		System.out.println("当做父类型Point处理");
		System.out.println(p.toString());
		System.out.println(p.distance());
	}
}
