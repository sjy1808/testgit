package homework;

import java.util.Scanner;

/*������ź��ºţ���ʾ����µ�����
 switch�ж��º�
 1,3,5,7,8,10,12
 4,6,9,11
 2
static int tianShu(int y, int m)*/
public class Day0401 {
	public static void main(String[] args) {
		System.out.print("������ţ�");
		int y=new Scanner(System.in).nextInt();
		System.out.print("�����·ݣ�");
		int m=new Scanner(System.in).nextInt();
		int n=tianshu(y,m);
		System.out.println(y+"��"+m+"��"+n+"��");
	}
	private static int tianshu(int y,int m) {
		if(m<1||m>12){
			return -1;//�����壬��ʾ����
		}
		int n=0;
		if(m==2){
			if(y%4==0&&y%100!=0||y%400==0){
				n=29;
			}else{
				n=28;
			}
		}else{
			switch(m){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:n=31;break;
			case 4:
			case 6:
			case 9:
			case 11:n=30;break;
			}
		}
		/*switch(m){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:n=31;break;
		case 4:
		case 6:
		case 9:
		case 11:n=30;break;
		}
		if(m==2&&(y%4==0&&y%100!=0||y%400==0)){
			n=29;
		}else {
			n=28;
		}*/
		return n;
	}
}
