package day0901;

public class Point {

	private int x;
	private int y;

	public Point() {
		super();
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj;
		// 参数三种特殊情况的判断
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Point))
			return false;
		return this.x == p.x && this.y == p.y;

	}
}
