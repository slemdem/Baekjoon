import java.io.*;
import java.util.*;

public class Solution {
	static int[] kcal;
	static int[] taste;
	static boolean[] visited;
	static int score, N, L;
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			kcal = new int[N];
			taste = new int[N];
			visited = new boolean[N];
			
			for(int i= 0; i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				taste[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}

			score = 0;

			subset(0,0,0);
			
			sb.append("#"+test_case+" "+score+"\n");
		}
		System.out.println(sb);
	}

	private static void subset(int n, int k, int t) {
		if(n==N) {
			if (k<=L&&t>score)
				score = t;
			return;
		}
		visited[n]=true;
		subset(n+1,k+kcal[n],t+taste[n]);
		visited[n]=false;
		subset(n+1,k,t);
	}

}