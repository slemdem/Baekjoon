import java.io.*;
import java.util.*;

public class Main {
	static int[][] dxdy= {{0,-1},{-1,0},{0,1},{1,0}};
	static ArrayList<Integer>[] relation;
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		relation = new ArrayList[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(relation[a]==null) relation[a] = new ArrayList<>();
			if(relation[b]==null) relation[b] = new ArrayList<>();
			
			relation[a].add(b);
			relation[b].add(a);
			
		}
		boolean result = false;
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			result = dfs(i,1);
			if(result) break;
		}
		
		if(result) System.out.println(1);
		else System.out.println(0);
	}

	private static boolean dfs(int i, int depth) {
		if (depth>=5) return true;
		visited[i] = true;
		
		if(relation[i]==null) return false;
//		System.out.println(i+" "+Arrays.toString(visited)+" "+Arrays.toString(relation[i].toArray())+" "+depth);
		
		for(int next: relation[i]) {
			if (visited[next]) continue;
			if(dfs(next, depth+1)) return true;
			visited[next] = false;
		}
		
		return false;
	}
}