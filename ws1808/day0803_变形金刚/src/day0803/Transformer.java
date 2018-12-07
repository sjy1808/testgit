package day0803;

public class Transformer {
	//变形金刚使用武器接口，武器接口作为成员变量定义
	private Weapon w;//null
	public void setWeapon(Weapon w){
		this.w=w;
	}
	public void attack(){
		if(w==null){
			System.out.println("用牙咬");
			return;
		}
		/*
		 * 把类别代码转换成类别字符串
		 */
		String type="";
		switch(w.getType()){
		case Weapon.TYPE_COLD:type="冷兵器";break;
		case Weapon.TYPE_HOT:type="热兵器";break;
		case Weapon.TYPE_NUCLEAR:type="核武器";break;
		}
		//使用冷兵器倚天剑进攻
		System.out.println("使用"+type+w.getName()+"进攻");
		w.kill();
	}
}
