package day1104;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test1 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(9527, "唐伯虎");
		map.put(9528, "秋香");
		map.put(9529, "石榴姐");
		map.put(9530, "华夫人");
		map.put(9531, "旺财");
		map.put(9532, "小青");
		map.put(9533, "法海");
		map.put(9534, "许仙");
		map.put(9535, "孙悟空");
		map.put(9535, "唐僧");
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
