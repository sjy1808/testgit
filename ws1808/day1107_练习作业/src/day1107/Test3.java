package day1107;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		System.out.println("��Ҫ����ʿ����");
		int n=new Scanner(System.in).nextInt();
		ArrayList<Soldier> list = new ArrayList<>(n);
		for(int i=1;i<=n;i++){
			Soldier a=new Soldier();
			a.id=i;
			list.add(a);
		}
		System.out.println("�Ѿ�������"+n+"��ʿ��");
		System.out.println("�س�����");
		while(true){
			new Scanner(System.in).nextLine();
			for(int i=0;i<list.size();i++){
				Soldier s=list.get(i);
				s.attack();
				if(s.blood==0){
					list.remove(i);
					
				}
			}
			System.out.println("ʿ��������"+list.size()+"\n\n");
		}
	}
}
