package day0703;

import java.util.Random;

/*
 * ��װ
 * 		��ʿ����ص��������ݣ���������룬��װ��һ�����ࡱ���
 */
public class Soldier {
	//��������
	//��Ա����
	int id;//Ĭ��ֵ0
	int blood=100;//Ĭ��100
	
	//��̬����
	static int count;
	//���췽��
	public Soldier(){
		System.out.println("�½�ʿ��ʵ��ʱ��ִ�й��췽��");
		
		Soldier.count++;
	}
	//��Ա����
	public void go(){
		System.out.println(id+"����ʿ��ǰ��");
	}
	public void attack(){
		if(blood==0){
			System.out.println("����"+id+"��ʿ����ʬ��");
			return;
		}
		System.out.println(id+"��ʿ������");
		//����ļ�Ѫ��
		int d=new Random().nextInt(10);
		blood-=d;
		if(blood<0){
			blood=0;
		}
		System.out.println("Ѫ��"+blood);
		if(blood==0){
			System.out.println(id+"��ʿ������");
			Soldier.count--;
		}
	}
	
}
