package day0304;

public class Test3 {
	public static void main(String[] args) {
		//double d=Math.random();
		//System.out.println(d);
		System.out.println("����һ��>0.999�����ֵ��");
		//����һ��f()�������ٵõ������ķ���ֵ�浽����d
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
				//�ѽ�����ص�����λ��
				return d;
			}
		}
	}
}
