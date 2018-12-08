package day1504;

public class Test2 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		Thread t1 = new Thread(r1);
		t1.start();
		R1 r2=new R1();
		while (true) {
			int i = r2.get();
			if (i % 2 == 1) {
				System.out.println(i);
				System.exit(0);
			}
		}
	}

	static class R1 implements Runnable {
		static int i;

		public synchronized void add() {
			i++;
			i++;
		}

		public synchronized int get() {
			return i;

		}

		@Override
		public void run() {
			while (true) {
				add();
			}
		}
	}
}