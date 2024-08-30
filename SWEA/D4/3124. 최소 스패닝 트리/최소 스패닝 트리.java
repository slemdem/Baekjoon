import java.io.*;
import java.util.*;


class Solution
{
	static int V,E;
	static PriorityQueue<int[]> edges;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int[] e = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
//				System.out.println(Arrays.toString(e));
				edges.add(e);
			}
			
			make();
			int cnt = 0;
			long result = 0;
			while(cnt<V-1) {
				int[] cur = edges.poll();
//				System.out.println(Arrays.toString(cur));
				if (union(cur[0],cur[1])) {
					result += cur[2];
//					System.out.println(cur[ +" "+ cur.to);
					cnt++;
				}
			}
			
			sb.append("#"+test +" "+result+"\n");
		}
		System.out.println(sb);
	}

	private static void make() {
		parent = new int[V+1];
		for(int i=0; i<=V; i++) parent[i] = i;
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