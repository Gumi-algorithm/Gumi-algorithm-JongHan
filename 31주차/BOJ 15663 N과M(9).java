package boj_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int arr[];
	static int perm[];
	static Set<String> result;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
	
		arr=new int[N];
		perm=new int[M];
		result=new LinkedHashSet<>();
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0,0);
		result.forEach(System.out::println);
	}
	static void dfs(int cnt,int flag) {
		if(cnt==M) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<M;i++) {
				sb.append(perm[i]).append(' ');
			}
			result.add(sb.toString());
			return;
		}
		
		for(int i=0;i<N;i++)
		{
			if((flag&1<<i)==1<<i)continue;
			perm[cnt]=arr[i];
			dfs(cnt+1,flag|1<<i);
		}
	}
}
