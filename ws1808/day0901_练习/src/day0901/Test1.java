package day0901;

public class Test1 {
	public static void main(String[] args) {
		Student s1=new Student(23,"男","张三",25);
		Student s2=new Student();
		s2.setId(24);
		s2.setGander("男");
		s2.setName("张思");
		s2.setAge(25);
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println("-------------");
		System.out.println(s1.equals(null));
		System.out.println(s1.equals(s1));
		System.out.println(s1.equals(15));
	}
}
