package day0305;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("����������");
		int n=new Scanner(System.in).nextInt();
		//����f()����
		//��n��ֵ���ݵ�f()�������м���
		f(n);
	}
	static void f(int n){
		if(n==2){
			System.out.println("2������");
			return;
		}
		//�ж�n��ֵ�Ƿ�������
		//��2��1+����n ��Χ�����ܰ�n��������
		
		//��1+����n��ֵ���浽����max
		double max=1+Math.sqrt(n);
		//ѭ��2��<max
		
		for(int i=2;i<max;i++){
			//�ж����n��i����
			if(n%i==0){
				//n��������
				System.out.println(n+"��������");
				//�������˽���
				//���ص�����λ�ü���ִ��
				return;
			}
		}
		System.out.println(n+"������");
		
	}
}
