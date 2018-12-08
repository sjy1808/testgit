package day0902;

public class Test2 {
	public static void main(String[] args) {
		String s0 = "abcdefghijklmnopqrstuvwxyz";
		String s = "";

		// 取系统当前时间的时间点，毫秒值
		// 毫秒值：从1970-1-1 0点开始的毫秒值
		long t = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s += s0;
		}
		t = System.currentTimeMillis() - t;
		System.out.println(t);
	}
}
