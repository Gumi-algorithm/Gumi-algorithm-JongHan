package boj_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int M,N,L;
	static int start=0,end=0,result=0;
	static int launch[];
	static int X,Y;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		launch=new int[M];
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
		{
			launch[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(launch);
		
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			X=Integer.parseInt(st.nextToken());
			Y=Integer.parseInt(st.nextToken());
			start=0;end=M-1;
			while(start<=end) {
				int mid=(start+end)/2;
				
				// 거리 구하기
				int sum=Y;
				sum+=Math.abs(launch[mid]-X);
				
				// 발사대에서 맞출 수 있으면 
				if(sum<=L) {
					result++;
					break;
				}
				else {
					if(launch[mid]<X)
					{
						start=mid+1;
					}
					else
					{
						end=mid-1;
					}
				}
			}
		}
		System.out.println(result);
	}

}
