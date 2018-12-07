package day1403;

public class Test2 {
	public static void main(String[] args) {
		R1 r=new R1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		//线程启动之后，执行r.run()方法
		t1.start();
		t2.start();
	}
	static class R1 implements Runnable{
		@Override
		public void run() {
			//获得正在执行这行代码的线程对象
			Thread t=Thread.currentThread();
			//获得线程名
			String n=t.getName();
			for(int i=0;i<=1000;i++){
				System.out.println(n+":"+i);
			}
		}
	}
}
