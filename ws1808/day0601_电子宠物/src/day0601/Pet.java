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
		System.out.println("快乐度："+happy+"饱食度："+full);
		
	}
	public void punish(){
		//哭叫声不写死，调用方法
		//子类重写cry方法
		System.out.println("打"+name+"的pp，"+name+"哭叫："+cry());
		happy-=10;
		System.out.println("快乐度："+happy);
	}
	//父类构造cry方法
	/*public String cry(){
		//无意义代码
		//子类中，应该重写这个方法
		//返回各自的哭叫声
		return "此处应有哭叫声";
	}*/
	/*
	 * 抽象方法：
	 * 只有方法的定义，没有方法体
	 * abstract:抽象
	 * 方法是抽象方法，类也必须是抽象类
	 */
	public abstract String cry();
	
	

}
