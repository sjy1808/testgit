package day0405_双色球;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
	public static void main(String[] args) {
		//红球号码数组和蓝球号码数组
		int[] r=zbsz(33);//准备数组
		int[] b=zbsz(16);//准备数组
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(b));
		
		//从数组r，随机选出6个不重复号码，存到变量red
		int[] red=xhq(r);//选红球
		//从数组b，随机选出1个号码，存到变量blue
		int blue=xlq(b);
		
		System.out.println("红球：");
		System.out.println(Arrays.toString(red));
		System.out.println("篮球：");
		System.out.println(blue);
	}
	private static int[] xhq(int[] r) {
		//i循环0到<6
		for(int i=0;i<6;i++){
			//随机下标j,范围[0，33)
			int j=new Random().nextInt(33);
			//交换i,j位置的值
			int t=r[i];
			r[i]=r[j];
			r[j]=t;
		}
		/*
		 * Arrays.copyOf(r,6)
		 * 复制数组的前六个位置，生成一个新的数组*/
		return  Arrays.copyOf(r,6);
	}
	private static int xlq(int[] b) {
		
		return b[new Random().nextInt(16)];
	}
	static int[] zbsz(int n){
		//新建n个长度的int[]数组，存到变量a
		int[] a=new int[n];
		//遍历a数组，放入1,2,3,4...
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
		}
		//返回数组a
		return a;
	}
	
	 
}
