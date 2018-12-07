package day0406;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		//产生随机乱序数组
		int[] a=suiji();
		System.out.println(Arrays.toString(a));
		System.out.println("------------------");
		
		sort(a);//排序方法
		
		System.out.println("------------------");
		System.out.println(Arrays.toString(a));
	}

	private static int[] suiji() {
		//产生一个随机整数n，作为数组长度
		//范围[5,11)或者5+[0,6)
		int n=5+new Random().nextInt(6);
		//新建n个长度的int[]数组，存到变量a
		int[] a=new int[n];
		//遍历数组a，填入100内随机整数
		for(int i=0;i<a.length;i++){
			a[i]=new Random().nextInt(100);
		}
		//返回数组a
		return a;
	}

	private static void sort(int[] a) {
		/*
		 * */
		for(int i=0;i<a.length;i++){
			boolean flag=false;//没有交换
			/*
			 * j循环，把较小值向前交换
			 * 最终，把最小值推到i的位置*/
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					int t=a[j];
					a[j]=a[j-1];
					a[j-1]=t;
					flag=true;//有交换，数据还是混乱的
				}
			}
			//j从后往前把数据捋一遍
			//位置都正确，没有数据交换
			if(!flag){  //!flag== flag==false
				break;//排序结束
			}
			System.out.println(Arrays.toString(a));
		}
	}
} 
