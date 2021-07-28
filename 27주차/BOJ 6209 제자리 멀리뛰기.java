package boj_6209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min=0,max,N,M,mid,ans;
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		max=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N+2];
		arr[N+1]=max;
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		while(min<=max)
		{
			mid=(min+max)/2;
			check();
		}
		
		System.out.println(ans);
	}
	static void check()
	{
		int idx=0;
		int cnt=0;
		for(int i=1;i<N+2;i++)
		{
			if(arr[i]-arr[idx]>=mid)
			{
				idx=i;
			}
			else
			{
				cnt++;
			}
		}
		if(cnt<=M)
		{
			min=mid+1;
			ans=mid;
		}
		else
		{
			max=mid-1;
		}
	}
}
