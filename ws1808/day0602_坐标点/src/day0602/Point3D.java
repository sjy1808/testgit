package day0602;

public class Point3D extends Point{
	int z;
	
	public Point3D(int x,int y,int z){
		//����û���޲ι���
		//super();ʧ��
		//��ʱ�����ֶ����ø����вι���
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
