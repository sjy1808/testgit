package day0301;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("��������������");
		int a=new Scanner(System.in).nextInt();
		int b=new Scanner(System.in).nextInt();
		int c=new Scanner(System.in).nextInt();
		
		//ȡab�����ֵ�����浽����max
		//ȡmax��c�����ֵ�����浽����max
		//int max=a>b?a:b;
		//max=max>c?max:c;
		
		//���������Ƕ��
		int max=a>b?(a>c?a:c):(b>c?b:c);
		System.out.println("���ֵ�ǣ�"+max);
		
	}
}
