package day1107;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Test13 {
	public static void main(String[] args) {
		System.out.println("�����������...");
		System.out.println("׼������������");
		int n=new Scanner(System.in).nextInt();
		LinkedList<Object> list = new LinkedList<>();
		for(int i=0;i<n;i++){
			list.add(1);
		}
		System.out.println("����׼����ϣ�");
		System.out.println("�±����");
		f1(list);
		System.out.println("����������");
		f2(list);
	}

	private static void f1(LinkedList<Object> list) {
		long t=System.currentTimeMillis();
		for(int i=0;i<list.size();i++){
			list.get(i);
		}
		t=System.currentTimeMillis()-t;
		System.out.println(t);
	}

	private static void f2(LinkedList<Object> list) {
		Iterator<Object> it = list.iterator();
		long t=System.currentTimeMillis();
		while(it.hasNext()){
			it.next();
		}
		t=System.currentTimeMillis()-t;
		System.out.println(t);
	}
}
