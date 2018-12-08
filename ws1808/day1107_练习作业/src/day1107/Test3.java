package day1107;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("需要多少士兵：");
		int n=new Scanner(System.in).nextInt();
		ArrayList<Soldier> list = new ArrayList<>(n);
		for(int i=1;i<=n;i++){
			Soldier a=new Soldier();
			a.id=i;
			list.add(a);
		}
		System.out.println("已经创建了"+n+"个士兵");
		System.out.println("回车进攻");
		while(true){
			new Scanner(System.in).nextLine();
			for(int i=0;i<list.size();i++){
				Soldier s=list.get(i);
				s.attack();
				if(s.blood==0){
					list.remove(i);
					
				}
			}
			System.out.println("士兵数量："+list.size()+"\n\n");
		}
	}
}
