package day1201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		Collections.addAll(list, "45","12","7","23","25","18","5","33","51");
		
		//����
		Collections.sort(list);//���ַ�˳������
		System.out.println(list);
		
		Comparator<String> c=new Comparator<String>(){
			/*
			 * o1��o2�Ƚϴ�С
			 * o1������
			 * o1С������
			 * ��ȣ�0
			 */
			@Override
			public int compare(String o1, String o2) {
				//o1,o2������int
				int a=Integer.parseInt(o1);
				int b=Integer.parseInt(o2);
				return a-b;
				
			}
		};//�Ƚ����������������     ����Ľӿڣ������½�����
		//�Ƚ������󣬽���sort()����ʹ�ã�sort()�����ڲ�����ñȽ�����compare()����
		Collections.sort(list,c);
		System.out.println(list);
		//for-each
		System.out.println("---------------");
		for (String string : list) {
			System.out.println(string);
			
		}
		System.out.println("-----------------");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
