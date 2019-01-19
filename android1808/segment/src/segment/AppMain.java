package segment;

import java.util.ArrayList;

public class AppMain {

	public static final ArrayList<Object> dic=new ArrayList<>();
	public static final int MAX_LENGTH=5;
	public static void main(String[] args) {
		dic.add("java");
		dic.add("编程");
		dic.add("语言");
		dic.add("北京天安门");
		//要切分的字符串
		String text="java是编程语言";
		//使用正向最大匹配算法进行切分
		ArrayList<String> keys=seg(text);
		//输出结果
		System.out.println(keys);
	}
	//正向最大匹配算法
	private static ArrayList<String> seg(String text) {
		//存在分次结果
		ArrayList<String> result=new ArrayList<>();
		
		while(text.length()>0){
			int len=MAX_LENGTH;
			if(text.length()<len){
				len=text.length();
			}
			//取指定的最大长度的文本去词典里面匹配
			String tryWord=text.substring(0,0+len);
			//1.判断候选词在不在词典中
			while(!dic.contains(tryWord)){
				//2.判断是不是单词
				if(tryWord.length()==1){
					break;
				}
				//3.去掉候选词右边一个字符
				tryWord=tryWord.substring(0, tryWord.length()-1);
			}
			result.add(tryWord);
			//带分词文本中去除已经分词的文本
			text=text.substring(tryWord.length());
		}
		return result;
	}
}