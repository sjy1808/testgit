package day1107;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test8 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		 set.add(888);
	      set.add(222);
	      set.add(666);
	      set.add(777);
	      set.add(111);
	      set.add(999);
	      set.add(777);
	      set.add(777);
	      System.out.println(set.size());
	      System.out.println(set);
	      System.out.println(set.remove(777));
	      System.out.println(set);
	      for( Iterator<Object> it = set.iterator();it.hasNext();){
	    	  Object i=it.next();
	    	  System.out.println(i);
	      }
	      System.out.println("-----------");
	      Iterator<Object> it = set.iterator();
	      while(it.hasNext()){
	    	  Object i=it.next();
	    	  System.out.println(i);
	    	  
	      }
	}
}
