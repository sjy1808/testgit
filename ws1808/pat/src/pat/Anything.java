package pat;

public class Anything {
	public Anything(){
		this("this调用有参数构造方法");
		System.out.println("无参数构造方法");
	}
	public Anything(String name){
		System.out.println("有参数构造方法");
	}
}
