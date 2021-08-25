package boj_20944;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			sb.append("a");
		}
		System.out.println(sb.toString());
	}

}
