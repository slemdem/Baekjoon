import java.util.*;
import java.io.*;

class Solution
{
	static int[] kcal;
	static int[] taste;
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
			
			for(int i= 0; i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				taste[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}

			score = 0;
			for(int i=0;i<N;i++) {
				score = Math.max(score, calculate(i+1,kcal[i],taste[i]));
			}
			
			sb.append("#"+test_case+" "+score+"\n");
		}
		System.out.println(sb);
	}

	private static int calculate(int n, int k, int t) {
		if (k==L) {
			return t;
		}
		if (k>L) {
			return 0;
		}
		int sco = t;
		for (int i= n; i<N;i++) {
			if (k+kcal[i]<=L) {
				sco = Math.max(sco, calculate(i+1,k+kcal[i],t+taste[i]));
			}
		}
		return sco;
	}
}