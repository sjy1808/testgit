package day1104;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(9527, "�Ʋ���");
		map.put(9528, "����");
		map.put(9529, "ʯ���");
		map.put(9530, "������");
		map.put(9531, "����");
		map.put(9532, "С��");
		map.put(9533, "����");
		map.put(9534, "����");
		map.put(9535, "�����");
		map.put(9535, "��ɮ");
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get(9532));
		System.out.println(map.get(9999));
		System.out.println(map.remove(9533));
		System.out.println(map.size());
		System.out.println(map);
		
		System.out.println("--------");
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		for(Iterator<Integer> it = keys.iterator();it.hasNext();){
			Integer k=it.next();
			String v=map.get(k);
			System.out.println(k+"="+v);
		}

	}
}
