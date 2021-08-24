package boj_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A,B,C,D;
	static int[] first,second;
	static long result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		//초기화
		A=new int[N];
		B=new int[N];
		C=new int[N];
		D=new int[N];
		
		// 입력 받기
		StringTokenizer st;
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			A[i]=Integer.parseInt(st.nextToken());
			B[i]=Integer.parseInt(st.nextToken());
			C[i]=Integer.parseInt(st.nextToken());
			D[i]=Integer.parseInt(st.nextToken());
		}
		
		// A+B, C+D 배열 만들기
		first=new int[N*N];
		second=new int[N*N];
		int cnt=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				first[cnt]=A[i]+B[j];
				second[cnt]=C[i]+D[j];
				cnt++;
			}
		}
		
		//정렬
		Arrays.sort(first);
		Arrays.sort(second); 
		
		// 두포인터로 0이되는 값 찾기
		int cnt1=0; // first 배열 탐색 인덱스
		int cnt2=N*N-1; // second 배열 탐색 인덱스
		while(cnt1<N*N&&cnt2>=0) {
			// 더한 값이 음수일 때
			if(first[cnt1]+second[cnt2]<0) {
				cnt1++;
			}
			// 더한 값이 양수일 때
			else if(first[cnt1]+second[cnt2]>0) {
				cnt2--;
			}
			// 더한 값이 0일 때
			else {
				cnt1++;
				cnt2--;
				long idx1=1, idx2=1;
				while(cnt1<N*N&&first[cnt1]==first[cnt1-1]) {
					cnt1++;idx1++;
				}
				while(cnt2>=0&&second[cnt2]==second[cnt2+1]) {
					cnt2--;idx2++;
				}
				result+=idx1*idx2;
			}
		}
		System.out.println(result);
	}

}
