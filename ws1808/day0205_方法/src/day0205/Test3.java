package day0205;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(1);
		//����f()����
		//�ٵõ�f()�����ķ���ֵ�����浽����r1
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
