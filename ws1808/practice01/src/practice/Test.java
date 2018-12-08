package practice;

import java.util.Arrays;

public class Test{
	public static void main(String[] args) {
		int[] a={15, 67, 26, 43, 61, 25, 84, 80, 34, 70};
		sort(a);
		System.out.println("------------------");
		System.out.println(Arrays.toString(a));
		
	}
	//方法五要素：修饰词、返回值类型、方法名、参数列表、方法体
	public static void sort(int[] a){
		for(int i=0;i<a.length-1;i++){
			int flag=0;
		
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
					flag=1;
				}
			}
			System.out.println(Arrays.toString(a));
			if(flag==0){
				return;
			}
		}
	}
}