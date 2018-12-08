package day1602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws Exception {
		System.out.println("���� һ��������");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		
		System.out.println(c.getPackage().getName());
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());
		System.out.println("\n\n--��Ա����--------------");
		f1(c);
		System.out.println("\n\n--���췽��--------------");
		f2(c);
		System.out.println("\n\n--����--------------");
		f3(c);
		
	}

	private static void f1(Class<?> c) {
		/*
		 * Field
		 * ��װһ�������Ķ�����Ϣ
		 * public static final int abc
		 */
		Field[] a=c.getDeclaredFields();
		for(Field f:a){
			//����
			String t=f.getType().getSimpleName();
			//������
			String n=f.getName();
			System.out.println(t+" "+n);
		}
	}

	private static void f2(Class<?> c) {
		//Constructor  ��װ���췽���Ķ�����Ϣ
		//public Xxx(int,String) throws  A,B,C
		Constructor<?>[] a=c.getDeclaredConstructors();
		for(Constructor<?> t:a){
			String n=c.getSimpleName();
			Class<?>[] p=t.getParameterTypes();
			System.out.println(n+"("+Arrays.toString(p)+")");
		}
	}

	private static void f3(Class<?> c) {
		/*
		 * Method  ��װ�����Ķ�����Ϣ
		 * public static final String f(int,double) throws
		 */
		Method[] a = c.getDeclaredMethods();
		for(Method t:a){
			Class<?> r = t.getReturnType();
			String n=t.getName();
			Class<?>[] p = t.getParameterTypes();
			System.out.println(r.getSimpleName()+" "+n+"("+Arrays.toString(p)+")");
		}
	}

	
}
