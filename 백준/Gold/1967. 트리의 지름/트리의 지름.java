import java.util.*;
import java.io.*;

public class Main {
	static int max;
	static LinkedList<int[]>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new LinkedList[N+1];
		for(int i=0;i<N+1;i++)
			tree[i] = new LinkedList<>();
		
		for (int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			
			tree[p].add(new int[] {c,w});
		}
		max=0;
		dfs(1);
		
		System.out.println(max);
	}
	
	private static int dfs(int i) {
		LinkedList<int[]> childs = tree[i];
		
		int[] maxs = new int[2];
		for (int[] n:childs) {
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
