package day1602;

import java.lang.reflect.Field;

public class Test3 {
	public static void main(String[] args) throws Exception, Exception {
		//Integer�������
		Class<Integer> c=Integer.class;
		//Integerʵ��
		Integer a=Integer.valueOf(5);
		
		//���value������ֵ
		Field f=c.getDeclaredField("value");
		
		//ʹ˽�б�����������
		f.setAccessible(true);
		//��ñ�����ֵ
		System.out.println(f.get(a));
		//���ñ�����ֵ
		f.set(a, 55);
		System.out.println(a.intValue());
		
	}
}
