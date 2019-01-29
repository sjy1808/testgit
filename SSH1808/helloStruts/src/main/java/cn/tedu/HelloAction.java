package cn.tedu;

public class HelloAction {

	/**
	 * 方法名默认为execute
	 */
	public String execute() {
		System.out.println("HelloWorld!");
		return "success";
	}
}
