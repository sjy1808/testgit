package day0601;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("������������֣�");
		String n= new Scanner(System.in).nextLine();
		Dog dog=new Dog(n);
		/*dog.name=n;
		dog.full=60;
		dog.happy=50;*/
		System.out.println("�Ѿ������� һֻ�µĳ��ﹷ");
		System.out.println("���س�");
		while(true){
			//�ȴ��س�
			new Scanner(System.in).nextLine();
			int r=new Random().nextInt(3);
			switch(r){
			case 0:dog.feed();break;
			case 1:dog.play();break;
			case 2:dog.punish();break;
			}
		}
	}
}
