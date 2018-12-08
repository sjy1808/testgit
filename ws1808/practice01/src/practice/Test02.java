package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test02{
	public static void main(String[] args) {
		int[] a=suiji();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for(int x:a){
			System.out.print(x+"\t");
		}
		int index1=0;
		while(index1<a.length){
			System.out.println(a[index1++]);
		}
		System.out.println("���ҵ�Ŀ��ֵ��");
		int t=new Scanner(System.in).nextInt();
		int index=binarySearch(a,t);
		System.out.println(index);
	}

	private static int[] suiji() {
		// TODO Auto-generated method stub
		int n=5+new Random().nextInt(6);
		int[] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}

	private static int binarySearch(int[] a, int t) {
		// TODO Auto-generated method stub
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