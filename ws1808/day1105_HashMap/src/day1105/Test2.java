package day1105;

import java.util.HashMap;

public class Test2 {
	public static void main(String[] args) {
		Point a = new Point(1, 3);
		Point b = new Point(1, 3);

		// ��ͬ��ϣֵ�����ܱ�֤�������ͬ�±�λ��
		System.out.println(a.hashCode());// ����Object��hashCode()����
		System.out.println(b.hashCode());//�ڴ��ַ

		// ��ʹ��ϣֵ��ͬ��equals()Ҳ�������
		// ���ܸ��ǣ�������������һ��
		System.out.println(a.equals(b));

		HashMap<Point, String> map = new HashMap<>();
		map.put(a, "3��");
		map.put(b, "3.1��");
		System.out.println(map);
	}
}
