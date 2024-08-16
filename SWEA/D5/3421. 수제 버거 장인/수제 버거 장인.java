import java.util.*;
import java.io.*;

class Solution
{
	static int N, M, C;
	static int[] ingredient;
	static boolean[] visited;
	static LinkedList<Integer>[] avoid;

	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			avoid = new LinkedList[N+1];
			visited = new boolean[N+1];
			
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()); 
				if(avoid[a]== null)
					avoid[a]= new LinkedList<>();
				if(avoid[b] == null)
					avoid[b]= new LinkedList<>();
				avoid[a].add(b);
				avoid[b].add(a);
			}

//			System.out.println(Arrays.deepToString(avoid));
			C = 0;
			
			visited[1] = true;
			combi(2);
			visited[1] = false;
			combi(2);
			
//			System.out.println("#"+test_case+" "+C+"\n");
			sb.append("#"+test_case+" "+C+"\n");
		}
		System.out.println(sb);
	}

	private static void combi(int i) {
		if (i>=N+1) {
			C++;
//			System.out.println(Arrays.toString(visited));
			return;
		}
		
		if(avoid[i]==null) {
			visited[i] = true;
			combi(i+1);
			visited[i] = false;
			combi(i+1);
		}else {
			boolean shouldAvoid=false;
//			System.out.println(i+" "+Arrays.toString(avoid[i].toArray()));
			for(int j : avoid[i]) {
				if (visited[j]) shouldAvoid=true;
			}
			
			if (shouldAvoid) {
				visited[i] = false;
				combi(i+1);
			}else {
				visited[i] = true;
				combi(i+1);
				visited[i] = false;
				combi(i+1);
			}
		}
	}

}