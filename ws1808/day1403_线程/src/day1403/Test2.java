package day1403;

public class Test2 {
	public static void main(String[] args) {
		R1 r=new R1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		//�߳�����֮��ִ��r.run()����
		t1.start();
		t2.start();
	}
	static class R1 implements Runnable{
		@Override
		public void run() {
			//�������ִ�����д�����̶߳���
			Thread t=Thread.currentThread();
			//����߳���
			String n=t.getName();
			for(int i=0;i<=1000;i++){
				System.out.println(n+":"+i);
			}
		}
	}
}
