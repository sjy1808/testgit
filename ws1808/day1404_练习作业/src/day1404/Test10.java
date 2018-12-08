package day1404;

public class Test10 {
	public static void main(String[] args) {
		f1();
		System.out.println("-------------");
		f2();
	}
	private static void f1() {
		// TODO Auto-generated method stub
		long t=System.currentTimeMillis();
		T1 t1 = new T1(1,10000000);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("质数数量："+t1.count);
		
		t=System.currentTimeMillis()-t;
		System.out.println("时间："+t);
	}
	private static void f2() {
		// TODO Auto-generated method stub
		long t=System.currentTimeMillis();
		T1 t1 = new T1(1,2000000);
		T1 t2 = new T1(2000000,4000000);
		T1 t3 = new T1(4000000,6000000);
		T1 t4 = new T1(6000000,8000000);
		T1 t5 = new T1(8000000,10000000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		int sum=t1.count+t2.count+t3.count+t4.count+t5.count;
		System.out.println("质数数量："+sum);
		
		t=System.currentTimeMillis()-t;
		System.out.println("时间："+t);
	}
	static class T1 extends Thread {
		int start;
		int end;
		int count;
		public T1(int start, int end) {
			//super();
			if(start<3){
				start=3;
				count=1;
			}
			this.start = start;
			this.end = end;
		}
		@Override
		public void run() {
			for(int i=start;i<end;i++){
				if(isPrime(i)){
					count++;
				}
			}
		}
		private boolean isPrime(int i) {
			double max=1+Math.sqrt(i);
			for(int n=2;n<max;n++){
				if(i%max==0){
					return false;
				}
			}
			return true;
		}
		
	}
}
