package day0602;

public class Test1 {
	public static void main(String[] args) {
		//�½�Point����3,4�㣬�浽����p1
		Point a=new Point(3,4);
		//����p1���toString()����
		//����ӡ��������ķ���ֵ
		String b=a.toString();
		System.out.println(b);
		System.out.println(a.toString());
		//����p1���distance()����
		//����ӡ��������ķ���ֵ
		double c=a.distance();
		System.out.println(c);
		System.out.println(a.distance());
	}
}
