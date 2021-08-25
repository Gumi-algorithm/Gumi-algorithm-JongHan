package boj_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int T;
	static char arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		T=Integer.parseInt(br.readLine());
		while(T-->0) {
			String str= br.readLine();
			arr=new char[str.length()];
			arr=str.toCharArray();
			Arrays.sort(arr);
			
			do {
				for(int i=0;i<arr.length;i++)
				{
					sb.append(arr[i]);
				}
				sb.append("\n");
			}
			while(next_permutation());
			
		}
		System.out.println(sb.toString());
	}

	static boolean next_permutation() {
		int i=arr.length-1;
		while(i>0&&arr[i-1]>=arr[i])
			i--;
		if(i<=0) return false;
		int j=arr.length-1;
		while(arr[i-1]>=arr[j])
			j--;
		char temp=arr[j];
		arr[j]=arr[i-1];
		arr[i-1]=temp;
		j=arr.length-1;
		while(i<j)
		{
			temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
			i++;
			j--;
		}
		return true;
	}
}
