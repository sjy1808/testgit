package day1404;

public class Test7 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		T1 t2 = new T1();
		t1.start();
		t2.start();
	}
	static class T1 extends Thread {
		@Override
		public void run() {
			String n=getName();
			for(int i=1;i<=1000;i++){
				System.out.println(n+":"+i);
			}
		}
	}
}
