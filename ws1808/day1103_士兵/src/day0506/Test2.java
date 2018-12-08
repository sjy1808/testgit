package day0506;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("需要多少士兵：");
		int n = new Scanner(System.in).nextInt();

		// 新建ArrayList集合，初始容量n
		ArrayList<Soldier> list = new ArrayList<>();
		for (int id = 1; id <= n; id++) {
			Soldier s = new Soldier();
			s.id = id;
			list.add(s);
		}
		System.out.println("已经创建" + n + "个士兵");
		System.out.println("回车进攻");
		// 有存活士兵
		while (list.size() != 0) {
			new Scanner(System.in).nextLine();
			/*for (int i = 0; i < list.size(); i++) {
				Soldier s = list.get(i);
				s.attack();
				if (s.blood == 0) {
					list.remove(i);
				}
			}*/
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Soldier s = (Soldier) iterator.next();
				s.attack();
				if(s.blood==0){
					//list.remove(s);迭代器遍历中不允许使用集合直接增删数据
					iterator.remove();//用迭代器的删除方法，删除甘冈取出的数据
				}
				
			}
			System.out.println("士兵数量：" + list.size() + "\n\n");
		}
	}
}
