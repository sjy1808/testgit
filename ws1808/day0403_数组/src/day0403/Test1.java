package day0403;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("\n\n-------------");
		f1();
		System.out.println("\n\n-------------");
		f2();
		System.out.println("\n\n-------------");
		f3();
		System.out.println("\n\n-------------");
		f4();
		System.out.println("\n\n-------------");
		f5();
	}
	static void f1(){
		//�½�5�����ȵ�int[]����
		//�ٰ������ڴ��ַ���浽����a
		int[] a=new int[5];
		//Arrays.toString(a)
		//���ã��������е����ݣ����ӳ��ַ���[ֵ1��ֵ2��ֵ3......]
		System.out.println(Arrays.toString(a));
		System.out.println(a);//��ӡ����a������ڴ��ַ
	}
	static void f2(){
		char[] a={'a','b','c'};
		System.out.println(Arrays.toString(a));
		System.out.println(a);
		
	}
	static void f3(){
		boolean[] a;
		a=new boolean[]{true,false,true,false};
		System.out.println(Arrays.toString(a));
		System.out.println(a[2]);
		
	}
	static void f4(){
		//�½�10�����ȵ�int[]����
		//��ַ���浽����a 
		int[] a=new int[10];
		//��������ÿ��λ��
		//��ÿ��λ�÷���100���������
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
			//a[i]=(int)Math.random()*100;
			System.out.println(a[i]);
		}
		//��ӡ
		System.out.println(Arrays.toString(a));
	}
	static void f5(){
		//�����������±�2,3����λ�õ�ֵ
		int[] a={5,4,54,6,51,51,51,46};
		//            2 3
		
		int t=a[2];
		a[2]=a[3];
		a[3]=t;
		System.out.println(Arrays.toString(a));
	}
}
