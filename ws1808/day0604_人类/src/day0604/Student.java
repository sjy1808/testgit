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
		 * ���ø����ж����toString()��������
		 * Ŀ����Ϊ�˼��ٴ����ظ�
		 */
		String s=super.toString();
		return s+","+school;
	}
	
}
