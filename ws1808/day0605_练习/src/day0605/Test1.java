package day0605;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		int[] a=suiji();
		System.out.println(Arrays.toString(a));
		System.out.println("-------------------");
		sort(a);
		System.out.println("-------------------");
		System.out.println(Arrays.toString(a));

	}


	private static int[] suiji() {
		int n=5+new Random().nextInt(6);
		int[] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		return a;
	}

	private static void sort(int[] a) {
		for(int i=0;i<a.length;i++){
			boolean flag=false;
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;
				}
				
			}
			if(!flag){
				break;
			}
			System.out.println(Arrays.toString(a));
		}
	}
}
