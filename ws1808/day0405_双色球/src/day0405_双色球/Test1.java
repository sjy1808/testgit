package day0405_˫ɫ��;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		//�����������������������
		int[] r=zbsz(33);//׼������
		int[] b=zbsz(16);//׼������
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(b));
		
		//������r�����ѡ��6�����ظ����룬�浽����red
		int[] red=xhq(r);//ѡ����
		//������b�����ѡ��1�����룬�浽����blue
		int blue=xlq(b);
		
		System.out.println("����");
		System.out.println(Arrays.toString(red));
		System.out.println("����");
		System.out.println(blue);
	}
	private static int[] xhq(int[] r) {
		//iѭ��0��<6
		for(int i=0;i<6;i++){
			//����±�j,��Χ[0��33)
			int j=new Random().nextInt(33);
			//����i,jλ�õ�ֵ
			int t=r[i];
			r[i]=r[j];
			r[j]=t;
		}
		/*
		 * Arrays.copyOf(r,6)
		 * ���������ǰ����λ�ã�����һ���µ�����*/
		return  Arrays.copyOf(r,6);
	}
	private static int xlq(int[] b) {
		
		return b[new Random().nextInt(16)];
	}
	static int[] zbsz(int n){
		//�½�n�����ȵ�int[]���飬�浽����a
		int[] a=new int[n];
		//����a���飬����1,2,3,4...
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
		}
		//��������a
		return a;
	}
	
	 
}
