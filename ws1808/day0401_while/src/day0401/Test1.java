package day0401;

public class Test1 {
	public static void main(String[] args) {
		//>0.999
		double d=f();
		System.out.println(d);
	}
	static double f(){
		double d=0;
		
		while(d<=0.999){
			d=Math.random();
		}
		return d;
	}
}
