package day0703;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//�½�Soldier[]���飬����5
		Soldier[] a=new Soldier[5];
		//�������飬�����½���5��ʿ������
		for(int i=0;i<a.length;i++){
			a[i]=new Soldier();
			a[i].id=i+1;
			
		}
		System.out.println("���س�����");
		//���д���ʿ��ʱ
		while(Soldier.count!=0){
			new Scanner(System.in).nextLine();
			//����ʿ��������һ��
			for(int i=0;i<a.length;i++){
				a[i].attack();
			}
			System.out.println("--------ʿ��������"+Soldier.count);
		}
	}
}
