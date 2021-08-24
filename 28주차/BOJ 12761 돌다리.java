package boj_12761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int A,B,N,M;
	static int result=Integer.MAX_VALUE;
	static boolean check[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		check=new boolean[100001];
		bfs();
		System.out.println(result);
	}

	static void bfs() {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {0,N});
		check[N]=true;
		
		while(!q.isEmpty()) {
			int cnt=q.peek()[0];
			int now=q.peek()[1];
			q.poll();
			
			if(now==M) {
				result=cnt;
				return;
			}
			
			//+1,-1
			if(now+1<=100000) {
				if(!check[now+1]) {
				q.offer(new int[] {cnt+1,now+1});
				check[now+1]=true;
				}
			}
			if(now-1>=0) {
				if(!check[now-1]) {
					q.offer(new int[] {cnt+1,now-1});
					check[now-1]=true;
				}
			}
			//+A,-A
			if(now+A<=100000) {
				if(!check[now+A]) {
					q.offer(new int[] {cnt+1,now+A});
					check[now+A]=true;
					}
			}
			if(now-A>=0) {
				if(!check[now-A]) {
					q.offer(new int[] {cnt+1,now-A});
					check[now-A]=true;
					}
			}
			//+B,-B
			if(now+B<=100000) {
				if(!check[now+B]) {
					q.offer(new int[] {cnt+1,now+B});
					check[now+B]=true;
					}
			}
			if(now-B>=0) {
				if(!check[now-B]) {
					q.offer(new int[] {cnt+1,now-B});
					check[now-B]=true;
					}
			}
			//*A,*B
			if(now*A<=100000) {
				if(!check[now*A]) {
					q.offer(new int[] {cnt+1,now*A});
					check[now*A]=true;
					}
			}
			if(now*B<=100000) {
				if(!check[now*B]) {
					q.offer(new int[] {cnt+1,now*B});
					check[now*B]=true;
					}
			}
		}
	}
	
}
