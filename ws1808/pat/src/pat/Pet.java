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
			System.out.println(name+"吃不下了");
			return;
		}
		System.out.println("给"+name+"喂食");
		full+=10;
		System.out.println("饱食度："+full);
	}
	public void play(){
		if(full==0){
			System.out.println(name+"饿的玩不动了");
			return;
		}
		System.out.println("陪"+name+"玩耍");
		full-=10;
		happy+=10;
		System.out.println("快乐度："+happy+",饱食度："+full);
	}
	public void punish(){
		System.out.println("打"+name+"哭叫："+cry());
		happy-=10;
		System.out.println("快乐度："+happy);
	}
	public String cry() {
		// TODO Auto-generated method stub
		return "此处有哭声";
	}
	
}
