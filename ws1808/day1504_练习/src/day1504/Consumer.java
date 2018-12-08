package day1504;

public class Consumer extends Thread{
	private Stack stack;

	public Consumer(Stack stack) {
		super();
		this.stack = stack;
	}
	@Override
	public void run() {
		while(true){
			synchronized (stack) {
				while(stack.index==0){
					try {
						stack.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				char c=stack.pop();
				System.out.println("µ¯³ö-->"+c);
				stack.notifyAll();
			}
		}
	}
	
}
