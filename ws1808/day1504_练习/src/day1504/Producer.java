package day1504;

import java.util.Random;

public class Producer extends Thread{
	private Stack stack;
	public Producer(Stack stack){
		this.stack=stack;
	}
	@Override
	public void run() {
		while(true){
			char c=(char) ('a'+new Random().nextInt(26));
			
			synchronized(stack){
				while(stack.index==5){
					try {
						stack.wait();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				stack.push(c);
				System.out.println("—π»Î<--"+c);
				stack.notifyAll();
			}
		}
	}
}
