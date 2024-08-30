import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int from, to;
	long distance;
	
	public Edge(int from, int to, double distance) {
		this.from = from;
		this.to = to;
		this.distance = (long) distance;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.distance - o.distance>0) return 1;
		else if (this.distance - o.distance<0) return -1;
		return  0;
	}
}

class Solution
{
	static int N, size, min, islands[][];
	static PriorityQueue<Edge> edges;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			
			islands = new int[N][2];
			for(int i=0; i<N; i++) {
				islands[i][0] = Integer.parseInt(st1.nextToken());
				islands[i][1] = Integer.parseInt(st2.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			
			edges = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long ver = Math.abs(islands[i][0]-islands[j][0]);
					long hor = Math.abs(islands[i][1]-islands[j][1]);
					long distance = (long) (Math.pow(ver,2)+Math.pow(hor,2));
//					System.out.println(i+" "+j+" "+distance);
					edges.add(new Edge(i, j,distance));
				}
			}
			
			make();
			int cnt = 0;
			long result = 0;
//			System.out.println(Arrays.toString(parent));
			while(cnt<N-1) {
				Edge cur = edges.poll();
//				System.out.println(cur.from +" "+ cur.to+" "+cur.distance);
				if (union(cur.from,cur.to)) {
					result += cur.distance;
//					System.out.println(cur.from +" "+ cur.to);
					cnt++;
				}
			}
			result = Math.round(result*E);
			sb.append("#"+test +" "+result+"\n");
		}
		System.out.println(sb);
	}

	private static void make() {
		parent = new int[N];
		for(int i=0; i<N; i++) parent[i] = i;
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