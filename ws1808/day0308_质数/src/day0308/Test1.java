package day0308;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("����һ������n����n������������:");
		int n=new Scanner(System.in).nextInt();
		//����f()����
		//��n��ֵ���ݵ�f()�������м���
		//�ٰѵõ���f()�����ķ���ֵ�����浽����r
		int r=f(n);
		System.out.println(r);
		
	}
	static int f(int n){
		//n<2������������û������
		if(n<2){
			return 0;
		}
		//��֪2���������Ѿ���һ������
		//����һ����������
		int count=1;
		
		//��3��n��Χ��Ѱ������
		outer:
		for(int i=3;i<=n;i++){
			//i��ֵ�Ƿ�������
			double max=Math.sqrt(i)+1;
			//��2��<max��Χ�ڣ����ܰ�i������ֵ
			for(int j=2;j<max;j++){
				//���i�ܱ�j����
				if(i%j==0){
					continue outer;
				}
			}
			//i����������������
			count++;
		}
		return count;
	}
}
