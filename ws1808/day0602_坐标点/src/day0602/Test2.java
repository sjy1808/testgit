package day0602;

public class Test2 {
	public static void main(String[] args) {
		Point3D p=new Point3D(3,4,5);
		System.out.println(p.distance());
		System.out.println(p.toString());
		
		Point p2= new Point(3,4);
		
		f(p);//Point3D����ת�ͳ�Point���ݵ�f()����
		f(p2);
	}
	public static void f(Point p){
		System.out.println("����������Point����");
		System.out.println(p.toString());
		System.out.println(p.distance());
	}
}
