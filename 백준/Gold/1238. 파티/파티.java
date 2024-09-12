import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[][] route = new int[N+1][N+1];

		for (int k =1; k<=N; k++) 
			Arrays.fill(route[k], Integer.MAX_VALUE);
		
		int from, to, weight;
		for (int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			route[from][to] = weight;
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		for (int i =1; i<=N; i++) {
			q.clear();
			for(int j =1; j<=N; j++) {
				if(route[i][j]!=Integer.MAX_VALUE) {
					q.add(new int[] {j, route[i][j]});
				}
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[1]<=route[i][cur[0]]) {
					route[i][cur[0]] = cur[1];
					cnt++;
					if(cur[0]==X || cnt==N-1) {
						break;
					}
				}
				
				for(int j =1; j<=N; j++) {
					if(i!=j && route[cur[0]][j]!=Integer.MAX_VALUE && route[i][j] >route[i][cur[0]]+route[cur[0]][j]) {
						q.add(new int[] {j, route[i][cur[0]]+route[cur[0]][j]});
						route[i][j] = route[i][cur[0]]+route[cur[0]][j];
					}
				}
			}
		}
		
		int max = 0;
		
		for (int i =1; i<=N; i++) {
			if(route[X][i]+route[i][X]> max) max =route[X][i]+route[i][X];
		}

		System.out.println(max);
	}
}