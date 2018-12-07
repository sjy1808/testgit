package day0901;

public class Student {
	private int id;
	private String name;
	private String gander;
	private int age;

	public Student() {
		super();
	}

	public Student(int id, String name, String gander, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gander = gander;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGander() {
		return gander;
	}

	public void setGander(String gander) {
		this.gander = gander;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "," + name + "," + gander + "," + age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student s = (Student) obj;
		return this.id == s.id && this.age == s.age && this.gander.equals(s.gander)  && this.name.equals(s.name);

	}
	
}
