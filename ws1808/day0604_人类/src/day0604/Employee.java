package day0604;

public class Employee extends Person{
	double salary;
	
	@Override
	public String toString() {
		return name+","+gender+","+age+","+salary;
	}
}
