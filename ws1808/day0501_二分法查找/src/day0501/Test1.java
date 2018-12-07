package day0501;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//���������������
		int[] a=suiji();
		//����,�Ż��Ŀ��������㷽��
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("���ҵ�Ŀ��ֵ��");
		int t=new Scanner(System.in).nextInt();
		//���ַ�����
		int index=binarySearch(a,t);
		System.out.println(t+"��λ���±�"+index);
	}

	private static int[] suiji() {
		//�������n,��Χ5+[0,6)
		int n=5+new Random().nextInt(6);
		//�½�n�����ȵ�int[]���飬�浽����a
		int[] a=new int[n];
		//��������a������100�ڵ����ֵ
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		//��������a
		return a;
	}

	private static int binarySearch(int[] a, int t) {
		/*
		 * 1.���� �����±����
		 * lo=0;
		 * hi=a.length-1;
		 * mid;�Ȳ���ֵ
		 * 2.��lo<=hi
		 * 		3.mid=(lo+hi)/2
		 * 		4.���midλ�ñ�t��
		 * 			5.hi��λ��mid-1λ��
		 * 		6.�������midλ��ֵ��tС
		 * 			7.lo��λ��mid+1λ��
		 * 		8.����
		 * 			9.����midֵ
		 * 10.�Ҳ������ݣ����ظ���������ֵ-1*/
		int lo=0;
		int hi=a.length-1;
		int mid;
		while(lo<=hi){
			mid=(lo+hi)/2;
			if(a[mid]>t){
				hi=mid-1;
			}else if(a[mid]<t){
				lo=mid+1;
			}else{
				return mid;
			}
		}
		return -1;
		
		
	}
}
