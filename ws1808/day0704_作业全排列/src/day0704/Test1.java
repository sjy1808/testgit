package day0704;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] a={1,2,3};
		//��0λ�ÿ�ʼ������ֵȫ����
		f(a,0);
	}

	private static void f(int[] a, int start) {
		// TODO Auto-generated method stub
		//�������
		if(start==a.length-1){
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start;i<a.length;i++){
			//i��startλ�ý���
			swap(a,i,start);
			f(a,start+1);//�ݹ��start+1֮���ֵ
			swap(a,start,i);
		}
	}

	private static void swap(int[] a, int start, int i) {
		// TODO Auto-generated method stub
		int t=a[start];
		a[start]=a[i];
		a[i]=t;
	}
}
