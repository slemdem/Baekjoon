import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<int[]> edges;
	static int[] parent;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		edges = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] e = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
//			System.out.println(Arrays.toString(e));
			edges.add(e);
		}
		
		make();
		int cnt = 0;
		long result = 0;
		while(cnt<N-1) {
			int[] cur = edges.poll();
//			System.out.println(Arrays.toString(cur));
			if (union(cur[0],cur[1])) {
				result += cur[2];
//				System.out.println(cur[ +" "+ cur.to);
				cnt++;
			}
		}
		System.out.println(result);
	}
	private static void make() {
		parent = new int[N+1];
		for(int i=0; i<=N; i++) parent[i] = i;
	}
	
	

	private static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if (aR == bR) return false;
		
		parent[bR] = aR;
		return true;
	}

	private static int find(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}

}