package cgb.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {

	public static void mian(String[] args) throws Exception{
		File file = new File("D://A.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		br.close();
		char[] b=line.toCharArray();
		System.out.println(b.toString());
		sort(b);
		String s = new String(b);
		BufferedWriter bw = new BufferedWriter(new FileWriter("B.txt"));
		bw.write(s);
		bw.newLine();
		bw.flush();
		bw.close();
	}

	private static void sort(char[] b) {
		for(int i=0;i<b.length;i++){
			for(int j=b.length-1;j>0;j--){
				if(b[i]>b[j]){
					char t=b[i];
					b[i]=b[j];
					b[j]=t;
				}
			}
		}
	}
}