package day0604;

public class Person {
	String name;
	String gender;
	int age;
	public Person(){
		System.out.println("Person()");
		
	}
	public Person(String name,String gender,int age){
		this.name=name;
		this.gender=gender;
		this.age=age;
		System.out.println("Person(1,2,3)");
		
	}
	public String toString(){
		return name+","+gender+","+age;
	}
}
