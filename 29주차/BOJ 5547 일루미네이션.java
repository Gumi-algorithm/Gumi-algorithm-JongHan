package boj_5547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int W, H, result = 0;
	static int board[][];
	static boolean check[][];
	static int oddDY[] = { -1, -1, 0, 0, 1, 1 };
	static int oddDX[] = { 0, 1, -1, 1, 0, 1 };
	static int evenDY[] = { -1, -1, 0, 0, 1, 1 };
	static int evenDX[] = { -1, 0, -1, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		check = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					result += 6;
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (check[i][j])
					continue;
				if (board[i][j] == 1)
					bfs(i, j);
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (check[i][j])
					continue;
				if (board[i][j] == 0)
					around(i,j);
			}
		}

		System.out.println(result);
	}

	static void bfs(int Y, int X) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { Y, X });
		check[Y][X] = true;

		while (!q.isEmpty()) {
			int nowY = q.peek()[0];
			int nowX = q.peek()[1];
			q.poll();
			if (nowY % 2 == 1) {
				for (int i = 0; i < 6; i++) {
					int nextY = nowY + evenDY[i];
					int nextX = nowX + evenDX[i];
					if (0 <= nextY && nextY < H && 0 <= nextX && nextX < W && board[nextY][nextX] == 1) {
						if (!check[nextY][nextX]) {
							result--;
							check[nextY][nextX] = true;
							q.offer(new int[] { nextY, nextX });
						} else {
							result--;
						}
					}
				}
			} else {
				for (int i = 0; i < 6; i++) {
					int nextY = nowY + oddDY[i];
					int nextX = nowX + oddDX[i];
					if (0 <= nextY && nextY < H && 0 <= nextX && nextX < W && board[nextY][nextX] == 1) {
						if (!check[nextY][nextX]) {
							result--;
							check[nextY][nextX] = true;
							q.offer(new int[] { nextY, nextX });
						} else {
							result--;
						}
					}
				}
			}
		}
	}


	static void around(int Y, int X) {
		int cnt = 0;
		boolean isArounded=true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {Y,X});
		check[Y][X]=true;
		
		while (!q.isEmpty()) {
			int nowY = q.peek()[0];
			int nowX = q.peek()[1];
			q.poll();
			if (nowY % 2 == 1) {
				for (int i = 0; i < 6; i++) {
					int nextY = nowY + evenDY[i];
					int nextX = nowX + evenDX[i];
					if (0 <= nextY && nextY < H && 0 <= nextX && nextX < W)
					{
						if(board[nextY][nextX]==0)
						{
							if(!check[nextY][nextX])
							{
								check[nextY][nextX]=true;
								q.offer(new int[] {nextY,nextX});
							}
						}
						else
						{
							cnt++;
						}
					}
					else
					{
						isArounded=false;
					}
				}
			} else {
				for (int i = 0; i < 6; i++) {
					int nextY = nowY + oddDY[i];
					int nextX = nowX + oddDX[i];
					if (0 <= nextY && nextY < H && 0 <= nextX && nextX < W)
					{
						if(board[nextY][nextX]==0)
						{
							if(!check[nextY][nextX])
							{
								check[nextY][nextX]=true;
								q.offer(new int[] {nextY,nextX});
							}
						}
						else
						{
							cnt++;
						}
					}
					else
					{
						isArounded=false;
					}
				}
			}
		}
		
		if(isArounded)
		result-=cnt;
	}
}
