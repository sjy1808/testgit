package day0207;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.print("����������");
		//�Ȼ�������ֵ
		//�ٱ��浽����n
		int n=new Scanner(System.in).nextInt();
		//����f()����
		//��n��ֵ�����ݵ�f()����
		//���м���
		f(n);
		
	}
	static void f(int a){
		//a���ƶ�24,16,8,0,λ����ǿת��byte
		byte b1=(byte)(a>>24);
		byte b2=(byte)(a>>16);
		byte b3=(byte)(a>>8);
		byte b4=(byte)(a>>0);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		//byteֵ�����ƶ�24������1����ȥ��
		//�ٲ�����������0,8,16,24,λ
		//����r��λ�򣬽���浽r
		int r=0;
		r=r|(b1<<24>>>0);
		r=r|(b2<<24>>>8);
		r=r|(b3<<24>>>16);
		r=r|(b4<<24>>>24);
		
		System.out.println(r);
		
		r=0;
		//byteֵ��0x000000ff��λ��
		//������24,16,8,0λ��
		//�ٺ�r��λ�򣬽���浽r
		r=r|((b1&0x000000ff)<<24);
		r=r|((b2&0x000000ff)<<16);
		r=r|((b3&0x000000ff)<<8);
		r=r|((b4&0x000000ff)<<0);
		
		System.out.println(r);
		
	}
}
