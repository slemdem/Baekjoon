import java.io.*;
import java.util.*;

class Solution
{
	static LinkedList<Integer>[] matrix;
	static boolean[] visited;
	static int[] level;
	static int N, M;
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		for (int test=1; test<=10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			matrix = new LinkedList[N+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=N;i++) matrix[i] = new LinkedList<Integer>();
			level = new int[N+1];
			
			for(int i=0; i<M; i++) {
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				matrix[node1].add(node2);
				level[node2] += 1;
			}
			
			
			sb.append("#"+test);
			Queue<Integer> que = new LinkedList<>();
			for(int i=1; i<=N; i++) {
				if(level[i]==0) que.add(i);
			}
			
			while (!que.isEmpty()) {
				int cur = que.poll();
				sb.append(" "+cur);
				for(int i : matrix[cur]) {
					level[i] -=1;
					if(level[i]==0) que.add(i);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}