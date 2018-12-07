package day0401;

public class Test2 {
	public static void main(String[] args) {
		//>0.999
		double d=f();
		System.out.println(d);
	}
	static double f(){
		double d=0;
		do{
			d=Math.random();
		}while(d<=0.999);
		return d;
		
	}
}
