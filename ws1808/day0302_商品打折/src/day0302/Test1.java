package day0302;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//��Ʒ������500,9��
		//��1000,85��
		//��3000,8��
		//��5000,75��
		System.out.println("����ԭ�ۣ�");
		double price=new Scanner(System.in).nextInt();
		//price��ֵ�����ݵ�f()���������ۿۼ�
		f(price);
	}
	static void f(double p){
		if(p<=0){
			System.out.println("ԭ�۴���");
			//f�����������˽���
			//ִ�����̣����ص�����λ�ü���ִ��
			return;
		}
		//�����ۿ۱���������d��Ĭ��1
		double d=1;
		//����ԭ��p�ķ�Χ����d���¸�ֵ
		if(p>=5000){
			d=0.7;
		}else if(p>=3000){
			d=0.8;
		}else if(p>=1000){
			d=0.85;
		}else if(p>=500){
			d=0.9;
		}
		
		//��������ۿۼ�
		p=p*d;//p*=d;
		System.out.println("ʵ�ʼ۸�"+p);
	}
}
