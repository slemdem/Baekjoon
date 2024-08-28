import java.io.*;
import java.util.*;


class Solution
{
	static int N, parents[];
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			for(int i=0; i<=N; i++) parents[i] = i;
			sb.append("#"+test +" ");
			for(int i=0; i<M;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(o==0) {
					union(a,b);
				}else {
					int ra = find(a);
					int rb = find(b);
					if (ra == rb) sb.append(1);
					else sb.append(0);
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int find(int i){
	    if (parents[i] == i) return i;
	    parents[i] = find(parents[i]);
	    return parents[i];
	}

	static boolean union(int a, int b){
	    int aRoot = find(a);
	    int bRoot = find(b);
	    
	    if (aRoot == bRoot) return false;
	    
	    parents[bRoot] = aRoot;
	    return true;
	}
}