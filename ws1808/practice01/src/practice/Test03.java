package practice;
import java.util.Scanner;
public class Test03{
	public static void main(String[] args){
		System.out.print("���뽵��ʱ�䣨�룩��");
		double t=new Scanner(System.in).nextDouble();
		double g=9.8;
		double s=g*t*t*1/2;
		System.out.println(s);
		System.out.println(t+"�뽵����"+s+"��");
		System.out.print("����Բ�İ뾶��");
		double r=new Scanner(System.in).nextDouble();
		double pi=3.14;
		double l=pi*2*r;
		double s1=pi*r*r;
		System.out.println("Բ���ܳ�Ϊ"+l);
		System.out.println("Բ�����Ϊ"+s1);
	}
}