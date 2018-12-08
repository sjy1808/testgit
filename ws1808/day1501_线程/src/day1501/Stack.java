package day1501;

public class Stack {
	private char[] a=new char[5];
	int index;
	public void push(char c){//往数组的下标位置放数据
		/*if(index==5){
			return;
		}*/
		a[index]=c;
		index++;
	}
	public char pop(){
		/*if(index==0){
			return ' ';
			
		}*/
		index--;
		char c=a[index];
		return c;
	}
	
}
