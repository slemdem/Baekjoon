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

		ArrayList<int[]>[] route = new ArrayList[N+1];

		for (int k =1; k<=N; k++) 
			route[k]= new ArrayList<>();
		
		int from, to, weight, cnt;
		for (int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			route[from].add(new int[] {to, weight});
		}

		int[] dij, go = new int[N+1], back = new int[N+1];
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		for (int i =1; i<=N; i++) {
			q.clear();
			dij = new int[N+1];
			for(int[] r : route[i]) {
				dij[r[0]] = r[1];
				q.add(r);
			}
			cnt = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[1]==dij[cur[0]]) {
					cnt++;
					if(cur[0]==X ) {
						go[i] = dij[X];
						break;
					}
					if(cnt==N-1) {
						back = dij.clone();
						break;
					}
				}
				
				for(int[] r : route[cur[0]]) {
					if(i==r[0]) continue;
					if(dij[r[0]] > dij[cur[0]]+r[1] || dij[r[0]]== 0 ) {
						dij[r[0]] = r[1]+dij[cur[0]];
						q.add(new int[] {r[0],r[1]+dij[cur[0]]});
					}
				}
			}
		}
		
		int max = 0;
		
		for (int i =1; i<=N; i++) {
			if(go[i]+back[i]> max) max = go[i]+back[i];
		}

		System.out.println(max);
	}
}