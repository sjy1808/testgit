package day1501;

public class Test3 {
	public static void main(String[] args) {
		R1 r1 = new R1();
		Thread t1=new Thread(r1);
		//r1.run() ,r1.add()
		t1.start();
		
		//main线程
		R1 r2=new R1();
		while(true){
			int i=r2.get();
			if(i%2==1){
				System.out.println(i);
				System.exit(0);//关闭虚拟机
			}
		}
	}
	static class R1 implements Runnable{
		static int i;
		public synchronized static void add(){
			i++;
			i++;
		}
		public synchronized static int get(){
			return i;
		}
		@Override
		public void run() {
			while(true){
				add();
			}
		}
	}
}
