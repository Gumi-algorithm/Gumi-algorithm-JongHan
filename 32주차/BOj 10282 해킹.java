package boj_10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int T,N,D,C;
	static ArrayList<ArrayList<Node>> list;
	static int dist[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		while(T-->0) {
			st =new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			D=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			
			list=new ArrayList<>();
			for(int i=0;i<=N;i++) {
				list.add(new ArrayList<>());
			}
			
			dist=new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for(int i=0;i<D;i++) {
				st =new StringTokenizer(br.readLine());
				int to=Integer.parseInt(st.nextToken());
				int from=Integer.parseInt(st.nextToken());
				int dist=Integer.parseInt(st.nextToken());
				list.get(from).add(new Node(to,dist));
			}
			dijkstra(C);
			
			int cnt=0;
			int result=0;
			for(int i=1;i<=N;i++) {
				if(dist[i]!=Integer.MAX_VALUE) {
					cnt++;
					result=Math.max(result, dist[i]);
				}
			}
			
			System.out.println(cnt+" "+result);
		}
	}
	static void dijkstra(int start) {
		PriorityQueue<Node> pq =new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			int dis=pq.peek().distance;
			int now=pq.peek().index;
			pq.poll();
			if(dist[now]<dis) {
				continue;
			}
			
			for(int i=0;i<list.get(now).size();i++) {
				int cost=dist[now]+list.get(now).get(i).distance;
				
				if(cost<dist[list.get(now).get(i).index]) {
					dist[list.get(now).get(i).index]=cost;
					pq.add(new Node(list.get(now).get(i).index,cost));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
	}
}
