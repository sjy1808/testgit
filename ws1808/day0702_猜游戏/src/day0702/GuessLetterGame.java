package day0702;

public class GuessLetterGame extends GuessGame{

	@Override
	public String suiji() {
		//TODO:假代码，之后再完成
		return "ABCDE";
	}

	@Override
	public void tiShi() {
		System.out.println("已经产生了5个不重复的大写字母");
		System.out.println("请猜这5个字母");
	}

	@Override
	public String biJiao(String c, String r) {
		//TODO:假代码，之后再完成
		return "2A2B";
	}

	@Override
	public boolean caiDui(String result) {
		return "5A0B".equals(result);
	}
	
}
