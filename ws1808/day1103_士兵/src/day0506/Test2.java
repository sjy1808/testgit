package day0506;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("��Ҫ����ʿ����");
		int n = new Scanner(System.in).nextInt();

		// �½�ArrayList���ϣ���ʼ����n
		ArrayList<Soldier> list = new ArrayList<>();
		for (int id = 1; id <= n; id++) {
			Soldier s = new Soldier();
			s.id = id;
			list.add(s);
		}
		System.out.println("�Ѿ�����" + n + "��ʿ��");
		System.out.println("�س�����");
		// �д��ʿ��
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
					//list.remove(s);�����������в�����ʹ�ü���ֱ����ɾ����
					iterator.remove();//�õ�������ɾ��������ɾ���ʸ�ȡ��������
				}
				
			}
			System.out.println("ʿ��������" + list.size() + "\n\n");
		}
	}
}
