package practice;
import java.util.Scanner;
public class Test06{
	public static void main(String[] args){
		/*System.out.print("��ţ�");
		int year=new Scanner(System.in).nextInt();
		if(year%4==0&&year%100!=0||year%400==0){
			System.out.println(year+"Ϊ����");
		}else{
			System.out.println(year+"Ϊƽ��");
		}*/
		System.out.println("��ţ�");
		int y=new Scanner(System.in).nextInt();
		boolean b=f(y);
		if(b){
			System.out.println("����");
		}else{
			System.out.println("ƽ��");
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