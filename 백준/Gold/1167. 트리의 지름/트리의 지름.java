import java.util.*;
import java.io.*;

public class Main {
	static int max;
	static LinkedList<int[]>[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new LinkedList[N+1];
		for(int i=0;i<N+1;i++)
			tree[i] = new LinkedList<>();
		
		int maxC = 0;
		LinkedList<Integer> maxPs = new LinkedList<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p= Integer.parseInt(st.nextToken());
			while (true) {
				int c= Integer.parseInt(st.nextToken());
				if(c == -1) break;
				int w= Integer.parseInt(st.nextToken());
				tree[p].add(new int[] {c,w});
			}
			if(maxC<tree[p].size()) {
				maxC = tree[p].size();
				maxPs = new LinkedList<>();
			}
			if(maxC == tree[p].size()) 
				maxPs.add(p);
			
		}
		max=0;
		visited = new boolean[N+1];
		visited[maxPs.peek()]= true;
		dfs(maxPs.peek());
		
		System.out.println(max);
	}
	
	private static int dfs(int i) {
		LinkedList<int[]> childs = tree[i];
		
		int[] maxs = new int[2];
		for (int[] n:childs) {
			if(visited[n[0]]) continue;
			
			visited[n[0]]= true;
			int result = dfs(n[0])+n[1];
			if(result>maxs[1]) {
				maxs[0]=maxs[1];
				maxs[1]=result;
			}else if(result>maxs[0]) {
				maxs[0]=result;
			}
		}
		if (max<maxs[0]+maxs[1]) max = maxs[0]+maxs[1];
		
		return maxs[1];
		
	}
}
