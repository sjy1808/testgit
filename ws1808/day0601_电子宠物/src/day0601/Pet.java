package day0601;

public abstract class Pet {

	String name;
	int full;
	int happy;
	
	public Pet(String name){
		this.name=name;
		full=50;
		happy=50;
	}
	
	public Pet(String name,int full,int happy){
		this.name=name;
		this.full=full;
		this.happy=happy;
	}
	
	public void feed(){
		if(full==100){
			System.out.println(name+"�Բ�����");
			return;
		}
		System.out.println("��"+name+"ιʳ");
		full+=10;
		System.out.println("��ʳ�ȣ�"+full);
	}
	public void play(){
		if(full==0){
			System.out.println(name+"�����治����");
			return;
		}
		System.out.println("��"+name+"��ˣ");
		full-=10;
		happy+=10;
		System.out.println("���ֶȣ�"+happy+"��ʳ�ȣ�"+full);
		
	}
	public void punish(){
		//�޽�����д�������÷���
		//������дcry����
		System.out.println("��"+name+"��pp��"+name+"�޽У�"+cry());
		happy-=10;
		System.out.println("���ֶȣ�"+happy);
	}
	//���๹��cry����
	/*public String cry(){
		//���������
		//�����У�Ӧ����д�������
		//���ظ��ԵĿ޽���
		return "�˴�Ӧ�п޽���";
	}*/
	/*
	 * ���󷽷���
	 * ֻ�з����Ķ��壬û�з�����
	 * abstract:����
	 * �����ǳ��󷽷�����Ҳ�����ǳ�����
	 */
	public abstract String cry();
	
	

}
