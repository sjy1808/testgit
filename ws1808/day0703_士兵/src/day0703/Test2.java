package day0703;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		//新建Soldier[]数组，长度5
		Soldier[] a=new Soldier[5];
		//遍历数组，存入新建的5个士兵对象
		for(int i=0;i<a.length;i++){
			a[i]=new Soldier();
			a[i].id=i+1;
			
		}
		System.out.println("按回车进攻");
		//当有存活的士兵时
		while(Soldier.count!=0){
			new Scanner(System.in).nextLine();
			//遍历士兵，进攻一轮
			for(int i=0;i<a.length;i++){
				a[i].attack();
			}
			System.out.println("--------士兵数量："+Soldier.count);
		}
	}
}
