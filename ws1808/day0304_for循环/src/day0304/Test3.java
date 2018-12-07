package day0304;

public class Test3 {
	public static void main(String[] args) {
		//double d=Math.random();
		//System.out.println(d);
		System.out.println("产生一个>0.999的随机值：");
		//调用一个f()方法，再得到方法的返回值存到变量d
		double d=f();
		System.out.println(d);
		
		double d2=g();
		System.out.println(d2);
	}
	static double g(){
		for(;;){
			double d=Math.random();
			if(d<=0.999){
				continue;
			}
			return d;
		}
	}
	static double f(){
		for(;;){
			double d=Math.random();
			if(d>0.999){
				//把结果返回到调用位置
				return d;
			}
		}
	}
}
