package boj_14575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N,T,total=0,min=0,max=0,result=0;
	static int S,start=0,end=0;
	static int sati[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		sati=new int[N][2];
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			sati[i][0]=Integer.parseInt(st.nextToken());
			sati[i][1]=Integer.parseInt(st.nextToken());
			start=Math.max(start, sati[i][0]);
			end=Math.max(end, sati[i][1]);
			total+=sati[i][1];
			min+=sati[i][0];
		}

		if(total<T||min>T)
		{
			System.out.println("-1");
			return;
		}
		
		while(start<=end) {
			int mid=(start+end)/2;
			int total=0;
			for(int i=0;i<N;i++) {
				if(sati[i][1]<mid)
				{
					total+=sati[i][1];
				}
				else
				{
					total+=mid;
				}
			}
			if(total>=T)
			{
				result=mid;
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		System.out.println(result);
	}
}
