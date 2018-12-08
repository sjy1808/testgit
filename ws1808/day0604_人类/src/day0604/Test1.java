package day0604;

public class Test1 {
	public static void main(String[] args) {
		Person p=new Person("张三","男",21);
		Student s=new Student();
		Employee e=new Employee();
		
		s.name="李四";
		s.gender="女";
		s.age=23;
		s.school="北京大学";
		
		e.name="王五";
		e.gender="女";
		e.age=19;
		e.salary=8000;
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		//多态
		f(p);
		f(s);
		f(e);
				
	}
	static void f(Person p){
		System.out.println("当做一致的父类型Person进行成处理");
		System.out.println(p.toString());
	}
}
