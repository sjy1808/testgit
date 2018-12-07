package day0604;

public class Student extends Person {
	String school;
	public Student(){
		System.out.println("Student()");
	}
	public Student(String name,String gender,int age,String school){
		super(name,gender,age);
		/*this.name=name;
		this.gender=gender;
		this.age=age;*/
		this.school=school;
		System.out.println("Student(1,2,3,4)");
	}
	
	@Override
	public String toString() {
		/*
		 * super.toString()
		 * 调用父类中定义的toString()方法代码
		 * 目的是为了减少代码重复
		 */
		String s=super.toString();
		return s+","+school;
	}
	
}
