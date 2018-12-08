package day1304;

public class Student {
	private int id;
	private String names;
	private String gender;
	private int age;
	public Student() {
		super();
	}
	public Student(int id, String names, String gender, int age) {
		super();
		this.id = id;
		this.names = names;
		this.gender = gender;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", names=" + names + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
