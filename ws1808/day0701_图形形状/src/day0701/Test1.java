package day0701;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		while(true){
			int r=new Random().nextInt(4);
			switch(r){
			case 0:
				//f(new Shape());
				System.out.println("�����࣬���ܴ�������");
				break;
			case 1:
				f(new Line());
				break;
			case 2:
				f(new Square());
				break;
			case 3:
				f(new Circle());
				break;
			}
		}
	}
	private static void f(Shape shape) {
		// TODO Auto-generated method stub
		//���س�  ����/����
		new Scanner(System.in).nextLine();
		shape.draw();
		//ת�ɸ����ͣ�ֻ�ܵ��ø��ඨ���ͨ�ó�Ա
		//shape.length();
		if(shape instanceof Line){//����shape��ʵ������Line����
			Line line=(Line)shape;
			line.length();
		}
		new Scanner(System.in).nextLine();
		shape.clear();
	}
	/*
	private static void f(Circle circle) {
		// TODO Auto-generated method stub
		//���س�  ����/����
		new Scanner(System.in).nextLine();
		circle.draw();
		new Scanner(System.in).nextLine();
		circle.clear();
	}
	private static void f(Square square) {
		// TODO Auto-generated method stub
		//���س�  ����/����
		new Scanner(System.in).nextLine();
		square.draw();
		new Scanner(System.in).nextLine();
		square.clear();
	}
	private static void f(Line line) {
		// TODO Auto-generated method stub
		//���س�  ����/����
		new Scanner(System.in).nextLine();
		line.draw();
		new Scanner(System.in).nextLine();
		line.clear();
	}
	private static void f(Shape shape) {
		// TODO Auto-generated method stub
		//���س�  ����/����
		new Scanner(System.in).nextLine();
		shape.draw();
		new Scanner(System.in).nextLine();
		shape.clear();
	}
	*/
}
