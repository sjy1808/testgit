package day0603_学生;

public class Student {
	int id;
	String name;
	String gender;
	int age;
	
	public Student(){
		
	}
	public Student(int id,String name){
		this(id,name,null,0);
		
	}
	public Student(int id,String name,String gender){
		//构造方法之间调用
		this(id,name,gender,0);
		
	}
	public Student(int id,String name,String gender,int age){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.age=age;
	}
	
	public String toString(){
		return id+","+name+","+gender+","+age;
	}
	
}
