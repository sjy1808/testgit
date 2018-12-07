package practice;
import java.util.Scanner;
public class Test06{
	public static void main(String[] args){
		/*System.out.print("年号：");
		int year=new Scanner(System.in).nextInt();
		if(year%4==0&&year%100!=0||year%400==0){
			System.out.println(year+"为润年");
		}else{
			System.out.println(year+"为平年");
		}*/
		System.out.println("年号：");
		int y=new Scanner(System.in).nextInt();
		boolean b=f(y);
		if(b){
			System.out.println("闰年");
		}else{
			System.out.println("平年");
		}
		String x=null;
		//int a=9;
		int a=(x!=null)&&(x.length()>0)?x.length():0;
		//a=a+y;
		System.out.println(x);
		
	}
	static boolean f(int y){
		boolean r=false;
		if(y%4==0&&y%100!=0||y%400==0){
			r=true;
		}
		return r;
	}
}