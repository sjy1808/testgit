package day0604;

public class Test1 {
	public static void main(String[] args) {
		Person p=new Person("����","��",21);
		Student s=new Student();
		Employee e=new Employee();
		
		s.name="����";
		s.gender="Ů";
		s.age=23;
		s.school="������ѧ";
		
		e.name="����";
		e.gender="Ů";
		e.age=19;
		e.salary=8000;
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		//��̬
		f(p);
		f(s);
		f(e);
				
	}
	static void f(Person p){
		System.out.println("����һ�µĸ�����Person���гɴ���");
		System.out.println(p.toString());
	}
}
