package homework;

import java.util.Scanner;

public class Day0402 {
	public static void main(String[] args) {
		System.out.println("�������һ��������");
		int a=new Scanner(System.in).nextInt();
		System.out.println("������ڶ���������");
		int b=new Scanner(System.in).nextInt();
		if(a<1||b<1){
			System.out.println("�������");
		}
		int n1=f1(a,b);
		long n2=f2(a,b);
		System.out.println("���Լ����"+n1);
		System.out.println("��С��������"+n2);
		/*int min,max;
		if(a>b){
			min=b;
			max=a;
		}else{
			min=a;
			max=b;
		}
		int n1=0;
		for(int i=min;i>0;i--){
			if(a%i==0&&b%i==0){
				n1=i;
				break;
			}
		}
		int n2=0;
		for(int j=max;;j+=max){
			if(j%a==0&&j%b==0){
				n2=j;
				break;
			}
		}
		System.out.println("���Լ����"+n1);
		System.out.println("��С��������"+n2);*/
	}

	private static int f1(int a,int b) {
		int min;
		if(a>b){
			min=b;
		}else{
			min=a;
		}
		int n1=0;
		for(int i=min;i>0;i--){
			if(a%i==0&&b%i==0){
				n1=i;
				break;
			}
		}
		return n1;
	}

	private static long f2(int a,int b) {
		int max;
		if(a<b){
			max=b;
		}else{
			max=a;
		}
		int n2=0;
		
		for(int j=max;;j+=max){
			if(j%a==0&&j%b==0){
				n2=j;
				break;
			}
		}
		return n2;
	}
}
