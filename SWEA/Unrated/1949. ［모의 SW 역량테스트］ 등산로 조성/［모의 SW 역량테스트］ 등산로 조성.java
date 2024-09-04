import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N,K,max;
	static int[] dx = {1,-1,0,0},dy= {0,0,1,-1};
	static int[][] map;
	static boolean[][] visited;
	static int sx, sy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			ArrayList<int[]> peeks = new ArrayList<>();
			int maxH = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(maxH<map[i][j]) {
						maxH = map[i][j];
						peeks = new ArrayList<>();
					}
					if(maxH==map[i][j])
						peeks.add(new int[] {i,j});
				}
			}
			max = 0;
			for(int[] pos:peeks) {
				visited[pos[0]][pos[1]] = true;
				dfs(pos[0], pos[1], map[pos[0]][pos[1]], 1, false);
				visited[pos[0]][pos[1]] = false;
			}
			
			sb.append("#"+test+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, int h, int depth, boolean b) {
		if(max<depth) max=depth;
//		System.out.printf("x: %d y: %d h: %d dep: %d %b\n",x,y,h,depth,b);
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<N && nx>=0 && ny<N && ny>=0 &&!visited[nx][ny]) {
				if(map[nx][ny]>=h && !b) {
					visited[nx][ny] = true;
					for(int k=1;k<=K;k++)
						if(map[nx][ny]-k<h)
							dfs(nx,ny,map[nx][ny]-k,depth+1,true);
					visited[nx][ny] = false;
				}else if(map[nx][ny]<h) {
					visited[nx][ny] = true;
					dfs(nx,ny,map[nx][ny],depth+1,b);
					visited[nx][ny] = false;
				}
			}
		}
	}
}
