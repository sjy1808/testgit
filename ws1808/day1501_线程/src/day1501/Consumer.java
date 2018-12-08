package day1501;

public class Consumer extends Thread {
	private Stack stack;

	public Consumer(Stack stack) {
		
		this.stack = stack;
	}
	@Override
	public void run() {
		while(true){
			synchronized (stack) {
				//���û������
				while(stack.index==0){
					//��ǰ�̣߳���ջ�����ϵȴ�
					try {
						stack.wait();
					} catch (InterruptedException e) {
					}
				}
				char c=stack.pop();
				System.out.println("����--->"+c);
				//֪ͨ��ջ�����ϵȴ����߳�
				stack.notifyAll();
			}
		}
	}
	
}
