package day0604;

public class Test2 {
	public static void main(String[] args) {
	
	/*	
	 * 1.先新建Person对象，
	 *   执行父类无参构造
	 * 2.在新建Student对象，
	 *   执行自己调用的无惨构造
	 */
	Student s1=new Student();
	/*
	 * 1.先新建Person对象，
	 *   默认执行父类无参构造
	 * 2.再新建Student对象，
	 *   执行自己调用的有参构造
	 */
	Student s2=new Student("a","b",4,"4");
	}
}
