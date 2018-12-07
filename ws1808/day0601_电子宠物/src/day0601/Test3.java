package day0601;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("1.��");
		System.out.println("2.è");
		System.out.println("3.����");
		System.out.println("4.��");
		System.out.println("---------------");
		while(true){
			System.out.print("��ѡ������һֻ�����������1~4����");
			int number=new Scanner(System.in).nextInt();
			System.out.print("����������ĳ���������֣�");
			String name= new Scanner(System.in).nextLine();
			
			Dog dog=null;
			Cat cat=null;
			Mouse mouse=null;
			Bird bird=null;

			switch(number){
			case 1:
				dog=new Dog(name);
				play(dog);
				break;
			case 2:
				cat=new Cat(name);
				play(cat);
				break;
			case 3:
				mouse=new Mouse(name,60,60);
				play(mouse);
				break;
			case 4:
				bird=new Bird(name);
				play(bird);
				break;

			default:
				System.out.println("�������");
				System.out.println("�밴�س�����");
				new Scanner(System.in).nextLine();
				break;
			}
		}
	}

	private static void play(Bird bird) {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println("�밴�س�");
			new Scanner(System.in).nextLine();
			int n=new Random().nextInt(3);
			switch(n){
			case 0:bird.feed();break;
			case 1:bird.play();break;
			case 2:bird.punish();break;
			}

		}
	}

	private static void play(Dog dog) {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println("�밴�س�");
			new Scanner(System.in).nextLine();
			int n=new Random().nextInt(3);
			switch(n){
			case 0:dog.feed();break;
			case 1:dog.play();break;
			case 2:dog.punish();break;
			}

		}
	}

	private static void play(Cat cat) {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println("�밴�س�");
			new Scanner(System.in).nextLine();
			int n=new Random().nextInt(3);
			switch(n){
			case 0:cat.feed();break;
			case 1:cat.play();break;
			case 2:cat.punish();break;
			}

		}
	}

	private static void play(Mouse mouse) {
		// TODO Auto-generated method stub
		while(true){
			//System.out.println("�밴�س�");
			new Scanner(System.in).nextLine();
			int n=new Random().nextInt(3);
			switch(n){
			case 0:mouse.feed();break;
			case 1:mouse.play();break;
			case 2:mouse.punish();break;
			}

		}
	}
}
