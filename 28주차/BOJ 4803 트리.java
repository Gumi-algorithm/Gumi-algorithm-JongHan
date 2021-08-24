package boj_4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int TC=1;
	static int N,M;
	static int parent[];
	static HashSet<Integer> set;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			// 정점, 간선 입력받기
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			// 종료 케이스
			if(N==0&&M==0)return;
			
			//초기화
			parent=new int[N+1];
			for(int i=1;i<=N;i++)
			{
				parent[i]=i;
			}
			set=new HashSet<>();
			
			for(int i=0;i<M;i++)
			{
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			for(int i=1;i<=N;i++) {
				int p=find(i);
				if(p>0) {
					set.add(p);
				}
			}
			
			if(set.isEmpty())
				System.out.println("Case "+TC+": No trees.");
			else if(set.size()==1)
				System.out.println("Case "+TC+": There is one tree.");
			else 
				System.out.println("Case "+TC+": A forest of "+set.size()+" trees.");
			TC++;
		}
	}
	static int find(int a) {
		if(parent[a]==a)return a;
		return parent[a]=find(parent[a]);
	}
	static void union(int a, int b) {
		int A=find(a);
		int B=find(b);
		if(A==B) {
			parent[B]=A;
			parent[A]=0;
		}
		else if(A>B) {
			parent[A]=B;
		}
		else {
			parent[B]=A;
		}
	}
}
