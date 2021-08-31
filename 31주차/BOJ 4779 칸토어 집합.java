package boj_4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] str;
	static int N,length;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		String input;
		while((input=br.readLine())!=null) {
			N=Integer.parseInt(input);
			length=(int) Math.pow(3, N);
			str=new char[length];
			for(int i=0;i<length;i++) {
				str[i]='-';
			}
			dfs(0,length);
			for(int i=0;i<length;i++)
				sb.append(str[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int start, int len) {
		if(len<3)return;
		for(int i=start+len/3;i<start+len*2/3;i++) {
			str[i]=' ';
		}
		dfs(start,len/3);
		dfs(start+len*2/3,len/3);
	}
}
