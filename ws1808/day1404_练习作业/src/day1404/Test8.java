package day1404;

public class Test8 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
	static class R1 implements Runnable{
		@Override
		public void run() {
			Thread t=Thread.currentThread();//获得正在执行这行代码的线程对象
			String name=t.getName();
			for(int i=1;i<=1000;i++){
				System.out.println(name+":"+i);
			}
			
		}
	}
}
