package boj_14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[][];
	static boolean check[][];
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		check=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,1,1,0);
		System.out.println(result);
	}
	static void comb(int cnt,int Y,int X,int sum)
	{
		
		if(cnt==3)
		{
			result=Math.min(result, sum);
			return;
		}
		for(int i=Y;i<N-1;i++)
		{
			if(i==Y)
			for(int j=X;j<N-1;j++)
			{
				if(!check[i][j]&&!check[i-1][j]&&!check[i+1][j]&&!check[i][j-1]&&!check[i][j+1])
				{
					check[i][j]=true;
					check[i-1][j]=true;
					check[i+1][j]=true;
					check[i][j-1]=true;
					check[i][j+1]=true;
					comb(cnt+1,Y,X+1,sum+arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1]+arr[i][j+1]);
					check[i][j]=false;
					check[i-1][j]=false;
					check[i+1][j]=false;
					check[i][j-1]=false;
					check[i][j+1]=false;
				}
			}
			else
			for(int j=1;j<N-1;j++)
			{
				if(!check[i][j]&&!check[i-1][j]&&!check[i+1][j]&&!check[i][j-1]&&!check[i][j+1])
				{
					check[i][j]=true;
					check[i-1][j]=true;
					check[i+1][j]=true;
					check[i][j-1]=true;
					check[i][j+1]=true;
					comb(cnt+1,Y,X+1,sum+arr[i][j]+arr[i-1][j]+arr[i+1][j]+arr[i][j-1]+arr[i][j+1]);
					check[i][j]=false;
					check[i-1][j]=false;
					check[i+1][j]=false;
					check[i][j-1]=false;
					check[i][j+1]=false;
				}
			}
		}
	}

}
