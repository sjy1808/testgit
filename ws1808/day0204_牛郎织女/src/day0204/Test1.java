package day0204;

public class Test1 {
	public static void main(String[] args) {
		//1光年是多少米
		long ly=299792458L*60*60*24*356;
		
		//16.4光年是多少米
		double d=16.4*ly;
		
		//喜鹊的数量
		double r=d/0.46;
		
		//天花板，向上取整
		//Math.ceil(r)
		//取整结果，是double类型74546.0
		//转型成long类型
		long n=(long)Math.ceil(r);
		System.out.println(ly);
		System.out.println(n);
		System.out.println(r);
	}
}
