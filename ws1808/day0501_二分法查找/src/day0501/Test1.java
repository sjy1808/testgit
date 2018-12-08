package day0501;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		//产生随机乱序数组
		int[] a=suiji();
		//排序,优化的快速排序算方法
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("查找的目标值：");
		int t=new Scanner(System.in).nextInt();
		//二分法查找
		int index=binarySearch(a,t);
		System.out.println(t+"的位置下标"+index);
	}

	private static int[] suiji() {
		//随机整数n,范围5+[0,6)
		int n=5+new Random().nextInt(6);
		//新建n个长度的int[]数组，存到变量a
		int[] a=new int[n];
		//遍历数组a，填入100内的随机值
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		//返回数组a
		return a;
	}

	private static int binarySearch(int[] a, int t) {
		/*
		 * 1.定义 三个下标变量
		 * lo=0;
		 * hi=a.length-1;
		 * mid;先不赋值
		 * 2.当lo<=hi
		 * 		3.mid=(lo+hi)/2
		 * 		4.如果mid位置比t大
		 * 			5.hi定位到mid-1位置
		 * 		6.否则如果mid位置值比t小
		 * 			7.lo定位到mid+1位置
		 * 		8.否则
		 * 			9.返回mid值
		 * 10.找不到数据，返回负数无意义值-1*/
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
