package day1107;

import java.util.HashMap;

public class Test7 {
	public static void main(String[] args) {
		Student s1 = new Student(8,"Ben","Man",21);
		Student s2 = new Student(8,"Ben","Man",21);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.equals(s2));
		HashMap<Student, Integer> map = new HashMap<>();
		map.put(s1, 89);
		map.put(s2, 92);
		System.out.println(map);
	}
}
