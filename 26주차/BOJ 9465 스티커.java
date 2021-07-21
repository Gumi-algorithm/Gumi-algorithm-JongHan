package boj_9465;
// 스티커 DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int T,N;
	static int arr[][],DP[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
			N=Integer.parseInt(br.readLine());
			arr=new int[2][N+1];
			DP=new int[2][N+1];
			
			for(int i=0;i<2;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			DP[0][1]=arr[0][1];
			DP[1][1]=arr[1][1];
			for(int j=2;j<=N;j++)
			{
				for(int i=0;i<2;i++)
				{
					DP[i][j]=Math.max(DP[i==0?1:0][j-1], DP[i==0?1:0][j-2])+arr[i][j];
				}
			}
			System.out.print(Math.max(DP[0][N], DP[1][N])+"\n");
		}
	}

}
