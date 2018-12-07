package day1403;

public class Test1 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t2 = new T1();
		
		//用start()方法启动线程
		//线程启动后，会自动执行润()方法代码
		t1.start();
		t2.start();
		System.out.println("main线程");
	}

	static class T1 extends Thread {
		// 静态类和普通类没有什么区别
		// 嵌套定义 （ 关系比较密切）也可以新建一个类
		@Override
		public void run() {
			// 获得线程名
			String n = getName();
			for (int i = 1; i <= 5; i++) {
				System.out.println(n + ":" + i);
			}
		}

	}
}
