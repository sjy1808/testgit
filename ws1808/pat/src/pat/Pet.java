package pat;

public class Pet {
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
		System.out.println("���ֶȣ�"+happy+",��ʳ�ȣ�"+full);
	}
	public void punish(){
		System.out.println("��"+name+"�޽У�"+cry());
		happy-=10;
		System.out.println("���ֶȣ�"+happy);
	}
	public String cry() {
		// TODO Auto-generated method stub
		return "�˴��п���";
	}
	
}
