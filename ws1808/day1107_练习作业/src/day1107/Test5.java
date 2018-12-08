package day1107;

import java.util.HashMap;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		System.out.println(" ‰»Î£∫");
		String s= new Scanner(System.in).nextLine();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			Integer count=map.get(c);
			if(count==null){
				map.put(c, i);
			}else{
				map.put(c, count+1);
			}
		}
		System.out.println(map);
	}
}
