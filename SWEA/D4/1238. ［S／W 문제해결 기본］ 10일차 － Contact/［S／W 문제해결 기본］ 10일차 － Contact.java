import java.io.*;
import java.util.*;


class Solution
{
	static HashMap<Integer,LinkedList<Integer>> web;
	static boolean[] visited;
	static int N;
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			web = new HashMap<>();
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(!web.containsKey(a)) {
					web.put(a, new LinkedList<>());
				}
				web.get(a).add(b);
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{S,0});
			visited[S] = true;
			int depth = 0;
			int max = 0;

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[1]>depth) {
					depth = cur[1];
					max = cur[0];
				}else if(cur[0]>max) max = cur[0];
				
				if(!web.containsKey(cur[0])) continue;
				
				LinkedList<Integer> child = web.get(cur[0]);
//				System.out.println(Arrays.toString(cur) + " " + Arrays.toString(child.toArray()));
				
				for (int next : child) {
					if (visited[next]) continue;
					q.add(new int[] {next,cur[1]+1});
					visited[next] = true;
				}
			}
			
			sb.append("#"+test+" "+max+"\n");
		}
		System.out.println(sb);
	}
}