package boj_18512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int result=Integer.MAX_VALUE;
	static int X,Y,P1,P2;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		P1=Integer.parseInt(st.nextToken());
		P2=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=100;i++) {
			for(int j=0;j<=100;j++) {
				int num1=X*i+P1;
				int num2=Y*j+P2;
				if(num1==num2) {
					result=Math.min(result, num1);
				}
			}
		}
		
		if(result==Integer.MAX_VALUE)System.out.println("-1");
		else
			System.out.println(result);
	}

}
