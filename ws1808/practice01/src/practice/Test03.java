package practice;
import java.util.Scanner;
public class Test03{
	public static void main(String[] args){
		System.out.print("输入降落时间（秒）：");
		double t=new Scanner(System.in).nextDouble();
		double g=9.8;
		double s=g*t*t*1/2;
		System.out.println(s);
		System.out.println(t+"秒降落了"+s+"米");
		System.out.print("输入圆的半径：");
		double r=new Scanner(System.in).nextDouble();
		double pi=3.14;
		double l=pi*2*r;
		double s1=pi*r*r;
		System.out.println("圆的周长为"+l);
		System.out.println("圆的面积为"+s1);
	}
}