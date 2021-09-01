package boj_6416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC=1;
		while(true) {
			HashMap<Integer,Integer> map=new HashMap<>();;
			int root=0;
			int edge=0;
			boolean isTree=true;
			boolean check=true;
			StringTokenizer st=null;
			
			while(true) {
				if(check)
					st= new StringTokenizer(br.readLine());
				else
					break;
				
				while(st.hasMoreTokens()) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				if(a==0&&b==0) {
					check=false;
					break;
				}
				if(a==-1&&b==-1)return;
				map.put(a, map.getOrDefault(a, 0));
				map.put(b, map.getOrDefault(b, 0)+1);
				edge++;
				}
				
			}
			
			for(Integer key: map.keySet()) {
				int val=map.get(key);
				if(val==0)root++;
				else if(val>1) {
					isTree=false;
				}
			}
			
			if(map.size()==0)System.out.println("Case "+TC+" is a tree.");
			else if(isTree&&(map.size()==edge+1)&&root==1)System.out.println("Case "+TC+" is a tree.");
			else System.out.println("Case "+TC+" is not a tree.");
			
			TC++;
		}
	}

}
