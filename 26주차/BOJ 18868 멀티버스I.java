package boj_18868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken()); // 우주의 크기
		N=Integer.parseInt(st.nextToken()); // 행성의 개수
		arr=new int[M][N];
		
		// 입력받기
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result=0;
		// process
		for(int i=0;i<M;i++)
		{
			for(int j=i+1;j<M;j++)
			{
				boolean check=false;
				for(int k=0;k<N;k++)
				{
					for(int l=0;l<N;l++)
					{
						// 조건을 만족하는지?
						if((arr[i][k]<arr[i][l]&&arr[j][k]<arr[j][l])||
							(arr[i][k]==arr[i][l]&&arr[j][k]==arr[j][l])||
							(arr[i][k]>arr[i][l]&&arr[j][k]>arr[j][l]))
						{
							continue;
						}
						else
						{
							check=true;
							break;
						}
					}
					if(check)
						break;
				}
				if(!check)
					result++;
			}
		}
		System.out.println(result);
	}

}
