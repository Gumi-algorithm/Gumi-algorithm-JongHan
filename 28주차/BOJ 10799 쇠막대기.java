package boj_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int result=0,temp=0;
	static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		str=br.readLine();
		for(int i=1;i<str.length();i++)
		{
			 if(str.charAt(i-1)=='('&&str.charAt(i)=='(') {
				 temp++;
				 result++;
			 }
			 else if(str.charAt(i-1)=='('&&str.charAt(i)==')') {
				 result=result+temp;
			 }
			 else if(str.charAt(i-1)==')'&&str.charAt(i)==')') {
				 temp=Math.max(0, temp-1);
			 }
		}
		System.out.println(result);
	}

}
