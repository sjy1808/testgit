package day0204;

public class Test1 {
	public static void main(String[] args) {
		//1�����Ƕ�����
		long ly=299792458L*60*60*24*356;
		
		//16.4�����Ƕ�����
		double d=16.4*ly;
		
		//ϲȵ������
		double r=d/0.46;
		
		//�컨�壬����ȡ��
		//Math.ceil(r)
		//ȡ���������double����74546.0
		//ת�ͳ�long����
		long n=(long)Math.ceil(r);
		System.out.println(ly);
		System.out.println(n);
		System.out.println(r);
	}
}
