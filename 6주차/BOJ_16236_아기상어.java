package boj_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,sharkY,sharkX,sharksize=2,size=0,result=1;
	static int[][] arr;
	static boolean visited[][];
	static int[] dy= {-1,0,1,0};
	static int[] dx= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==9)
				{
					sharkY=i;
					sharkX=j;
				}
			}
		}
		bfs(sharkY,sharkX);
		System.out.println(result);
		
	}
	
	static void bfs(int Y,int X)
	{
		int dist=0;
		Queue<pair> q= new LinkedList<>();
		q.offer(new pair(Y,X));
		visited[Y][X]=true;
		while(!q.isEmpty())
		{
			//현재 탐색할 좌표
			int nowY=q.peek().first;
			int nowX=q.peek().second;
			q.poll();
			//거리가 현재보다 커지면 result++
			if(dist<(sharkY-nowY)+(sharkX-nowX))
			{
				dist=(sharkY-nowY)+(sharkX-nowX);
				result++;
			}
			//4방위  탐색
			for(int i=0;i<4;i++)
			{
				// 다음에 탐색할 좌표
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX]&&arr[nextY][nextX]<=sharksize) // 범위 내에 있을 때
				{
					System.out.println("result"+result+" "+nextY+" "+nextX);
					if(arr[nextY][nextX]<sharksize&&arr[nextY][nextX]!=0) // 먹을 수 있는 물고기를 발견하면 먹는다.
					{
						/////////////////////////////////////
						
						// 먹을 수 있는 물고기를 발견하면 4방위 탐색을 하면서 가장 작은 물고기가 있는 좌표를 저장하는 코드
						
						//////////////////////////////////////
						size++; //먹은 횟수 증가
						if(size==sharksize) //먹은 횟수와 상어 크기가 같으면 상어 크기 증가
						{
							size=0;
							sharksize++;
						}
						//먹은 좌표 0으로 저장
						arr[nextY][nextX]=0;
						
						//상어의 좌표 저장
						sharkY=nextY;
						sharkX=nextX;
						bfs(nextY,nextX); // 다음좌표로 이동
						return;
					}
					q.offer(new pair(nextY,nextX));
					visited[nextY][nextX]=true;
				}
			}
		}
	}
	
	static class pair{ // 좌표를 저장하기 위한 객체
		int first;
		int second;
		pair(int first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}
}
