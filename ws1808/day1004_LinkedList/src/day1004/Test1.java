package day1004;

import java.util.Iterator;
import java.util.LinkedList;

public class Test1 {
	public static void main(String[] args) {
		/*
		 * <>���� �������Ƽ����д�ŵ��������� �����﷨��֧�ֻ������� ���ϲ����� ��Ż������ͣ����ð�װ������
		 */
		LinkedList<String> list = new LinkedList<>();
		list.add("qqq");
		list.add("sss");
		list.add("www");
		list.add("xxxx");
		list.add("xd");
		list.add("dfg");
		list.add("cvcxz");
		list.add("sss");
		list.add("ddd");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.remove(3));
		System.out.println(list);
		System.out.println(list.remove("xxxx"));
		System.out.println(list);
		System.out.println("------------------");
		// ˫�������±������Ч�ʵ�
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------------------");
		// ��������
		// �½�����������
		Iterator<String> it = list.iterator();
		// ��������
		while (it.hasNext()) {
			// ȡ��һ������
			String s = it.next();
			System.out.println(s);
		}
	}
}
