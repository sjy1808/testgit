package day1403;

public class Test4 {
	public static void main(String[] args) {
		System.out.println("\n\n---单线程--------");
		f1();
		System.out.println("\n\n---多线程5个--------");
		f2();
	}
	
	private static void f2() {
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
		//main线程等待5个线程结束
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
		}
		int sum=t1.count+t2.count+t3.count+t4.count+t5.count;
		System.out.println("质数数量："+sum);
		t=System.currentTimeMillis()-t;
		System.out.println("时间："+t);
	}

	private static void f1() {
		long t=System.currentTimeMillis();
		T1 t1=new T1(1,10000000);
		t1.start();
		//main线程暂停，等待t1执行结束，再继续
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		System.out.println("质数数量："+t1.count);
		t=System.currentTimeMillis()-t;
		System.out.println("时间："+t);
	}

	static class T1 extends Thread {
		int start;
		int end;
		int count;
		public T1( int start, int end) {
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
		private boolean isPrime(int n) {
			double max=1+Math.sqrt(n);
			for(int i=2;i<max;i++){
				if(n%i==0){
					return false;
				}
			}
			return true;
		}
		
	}
}
