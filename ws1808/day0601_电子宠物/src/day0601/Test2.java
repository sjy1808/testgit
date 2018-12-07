package day0601;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("1.狗");
		System.out.println("2.猫");
		System.out.println("-------------");
		System.out.print("选择：");
		int a=new Scanner(System.in).nextInt();
		System.out.print("起个名字：");
		String n= new Scanner(System.in).nextLine();
		
		/*Dog dog=null;
		Cat cat=null;
		if(a==1){
			dog=new Dog(n);
			play(dog);
		}else if(a==2){
			cat=new Cat(n);
			play(cat);
		}else{
			System.out.println("输入错误");
		}*/
		Pet pet=null;
		if(a==1){
			pet=new Dog(n);
		}else if(a==2){
			pet=new Cat(n);
		}else{
			System.out.println("输入错误");
		}
		play(pet);
		
	}
	private static void play(Pet pet) {
		// TODO Auto-generated method stub
		
		while(true){
			System.out.println("请按回车");
			new Scanner(System.in).nextLine();
			int r=new Random().nextInt(3);
			switch(r){
			case 0:pet.feed();break;
			case 1:pet.play();break;
			case 2:pet.punish();break;
			}
					
		}
	}
	/*private static void play(Dog dog) {
		// TODO Auto-generated method stub
		
		while(true){
			System.out.println("请按回车");
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
			System.out.println("请按回车");
			new Scanner(System.in).nextLine();
			int r=new Random().nextInt(3);
			switch(r){
			case 0:cat.feed();break;
			case 1:cat.play();break;
			case 2:cat.punish();break;
			}
					
		}
	}*/
	
	
}
