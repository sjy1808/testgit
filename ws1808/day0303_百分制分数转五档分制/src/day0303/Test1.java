package day0303;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		/*
		 *�ٷ��Ʒ�����ת���嵵����
		A  [90,100]
		B  [70,90)
		C  [60,70)
		D  [20,60)
		E  [0,20) */
		System.out.println("�ٷ��Ʒ�����");
		int s=new Scanner(System.in).nextInt();
		//���÷���f()
		//��sɫֵ���ݵ�f()�������м���
		f(s);
	}
	static void f(int score){
		if(score<0||score>100){
			System.out.println("��������ȷ");
			//f()�������˽���
			//���ص�����λ�ü���
			return;
		}
		//����һ����������������Ĭ��ֵ0
		char r=0;
		//����score����r��ֵ
		switch(score/10){
		case 10:
		case 9:
			r='A';
			break;
		case 8:
		case 7:
			r='B';
			break;
		case 6:
			r='C';
			break;
		case 5:
		case 4:
		case 3:
		case 2:
			r='D';
			break;
		case 1:
		case 0:
			r='E';
			break;
			
		}
		System.out.println("�嵵�����ǣ�"+r);
	}
}
