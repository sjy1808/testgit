package day1501;

import java.util.Random;

public class Producer extends Thread{
	private Stack stack;
	
	public Producer(Stack stack){
		this.stack=stack;
	}
	@Override
	public void run() {
		while(true){
			char c=(char)('a'+new Random().nextInt(26));
			
			synchronized(stack){
				//Èç¹û Õ»´æÂú
				while(stack.index==5){
					try {
						stack.wait();
					} catch (InterruptedException e) {
					}
				}
				stack.push(c);
				System.out.println("Ñ¹Èë<--"+c);
				stack.notifyAll();
			}
		}
	}
}
