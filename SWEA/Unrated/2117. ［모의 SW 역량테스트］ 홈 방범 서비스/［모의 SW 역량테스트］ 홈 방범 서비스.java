import java.io.*;
import java.util.*;

class Solution {
	
	static int N, M, C;
	static int[][] map, dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					max = Math.max(max, profitHouse(i,j));
				}
			}
			sb.append("#"+test+" "+max+"\n");
		}
		System.out.println(sb);
	}

	private static int profitHouse(int x, int y) {
		int max = 0;
		int[] amounts = bfs(x,y);
//		System.out.println(Arrays.toString(amounts));
		for(int k=1; k<2*N; k++) {
			if(k*k+(k-1)*(k-1)<=amounts[k]*M && max<amounts[k]) max = amounts[k];
		}
		return max;
	}

	private static int[] bfs(int x, int y) {
		int[] amounts = new int[2*N];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		visited = new boolean[N][N];
		visited[x][y] = true;
		
		int cnt=1;
		int houses = 0;
		while(!q.isEmpty()) {
			int n =q.size();
			for(int i=0; i<n;i++) {
				int[] cur = q.poll();
				if(map[cur[0]][cur[1]]==1) houses++;
				for(int d=0; d<4; d++) {
					int nx = cur[0]+dxdy[d][0];
					int ny = cur[1]+dxdy[d][1];
					if(nx<N && nx>=0 && ny<N && ny>=0 && !visited[nx][ny]) {
						q.offer(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
				}
			}
			amounts[cnt++] = houses;
		}
		return amounts;
	}

}