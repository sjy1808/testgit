package day0206;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("��ţ�");
		//�Ȼ�������ֵ
		//�ٱ��浽����y
		int y=new Scanner(System.in).nextInt();
		
		//����f()����
		//��y��ֵ���ݵ�f()������������
		f(y);
		
	}
	static void f(int year){
		//�����ַ���������Ĭ����"ƽ��"
		//��������ж������꣬�ٰ�r��ֵ�޸ĳ�����
		String r="ƽ��";
		//year ������ֵ���ܷ�4����
		/*if(year%4==0){
			//�ܱ�4�����������
			//���жϣ����ܱ�100����
			if(year%100!=0){
				r="����";
			}
		}
		
		//���year�ܱ�400����
		if(year%400==0){
			r="����";
		}*/
		//����ܱ�4���������Ҳ��ܱ�100����
		//���ߣ��ܱ�400����
		if((year%4==0&&year%100!=0)||year%400==0){
			r="����";
			
		}
		System.out.println(year+"����"+r);
	}
}
