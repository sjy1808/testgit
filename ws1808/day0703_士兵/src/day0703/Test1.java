package day0703;

public class Test1 {
	public static void main(String[] args) {
		//新建士兵对象，内存地址保存到变量s1
		Soldier s1=new Soldier();
		Soldier s2=new Soldier();
		
		//用s1,引用到对象的内存空间，访问它的id变量
		s1.id=9527;
		s2.id=9528;
		
		//用s1引用第一个士兵对象，控制它执行go()方法代码
		s1.go();
		s2.go();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		s2.attack();
		
	}
}
