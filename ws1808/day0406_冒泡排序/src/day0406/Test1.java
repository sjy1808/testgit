package day0406;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		//���������������
		int[] a=suiji();
		System.out.println(Arrays.toString(a));
		System.out.println("------------------");
		
		sort(a);//���򷽷�
		
		System.out.println("------------------");
		System.out.println(Arrays.toString(a));
	}

	private static int[] suiji() {
		//����һ���������n����Ϊ���鳤��
		//��Χ[5,11)����5+[0,6)
		int n=5+new Random().nextInt(6);
		//�½�n�����ȵ�int[]���飬�浽����a
		int[] a=new int[n];
		//��������a������100���������
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		//��������a
		return a;
	}

	private static void sort(int[] a) {
		/*
		 * */
		for(int i=0;i<a.length;i++){
			boolean flag=false;//û�н���
			/*
			 * jѭ�����ѽ�Сֵ��ǰ����
			 * ���գ�����Сֵ�Ƶ�i��λ��*/
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;//�н��������ݻ��ǻ��ҵ�
				}
			}
			//j�Ӻ���ǰ��������һ��
			//λ�ö���ȷ��û�����ݽ���
			if(!flag){  //!flag== flag==false
				break;//�������
			}
			System.out.println(Arrays.toString(a));
		}
	}
} 
