package pat;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("1.��");
		System.out.println("2.è");
		System.out.println("----------------");
		System.out.println("ѡ��");
		int c=new Scanner(System.in).nextInt();
		System.out.println("������֣�");
		String n = new Scanner(System.in).nextLine();
		Dog dog=null;
		Cat cat=null;
		if(c==1){
			dog=new Dog(n);
			play(dog);
		}else{
			cat=new Cat(n);
			play(cat);
		}
		
		//String str=new String("bb");
	}

	private static void play(Dog dog) {
		// TODO Auto-generated method stub
		while(true){
			new Scanner(System.in).nextLine();
			int r=new Random().nextInt(3);
			switch(r){
			case 0:dog.feed();break;
			case 1:dog.play();break;
			case 2:dog.punish();break;
			}
		}
	}

	private static void play(Cat cat) {
		// TODO Auto-generated method stub
		while(true){
			new Scanner(System.in).nextLine();
			int r=new Random().nextInt(3);
			switch(r){
			case 0:cat.feed();break;
			case 1:cat.play();break;
			case 2:cat.punish();break;
			}
		}
	}
}
