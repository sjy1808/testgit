package day0602;

public class Point3D extends Point{
	int z;
	
	public Point3D(int x,int y,int z){
		//父类没有无参构造
		//super();失败
		//此时必须手动调用父类有参构造
		super(x,y);
		this.z=z;
	}
	@Override
	public double distance() {
		return Math.sqrt(x*x+y*y+z*z);
	}
	@Override
	public String toString() {
		return "("+x+","+y+","+z+")";
	}
}
