import java.io.*;
import java.util.*;

class Solution
{
	static HashSet<Integer> visited;
	static int[][] dxdy = {{1,1},{1,-1},{-1,-1},{-1,1}};
	static int[][] board;
	static int[] level;
	static int N, sx, sy, max;
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N+2][N+2];
			for(int i=1; i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N;j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = -1;
			for(int i=1; i<N-1; i++) {
				for(int j=2; j<N;j++) {
					visited = new HashSet<>();
					visited.add(0);
					sx=i; sy=j;
					dfs(i,j,0,0);
				}
			}
			
			sb.append("#"+test+" "+max+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int d, int depth) {
		if(x==sx && y==sy && depth>1) {
			max = Math.max(max, depth);
			return;
		}
		if(visited.contains(board[x][y])) return;
		
		visited.add(board[x][y]);
		
//		System.out.println(Arrays.deepToString(visited.toArray())+" "+x+" "+y);
		dfs(x+dxdy[d][0], y+dxdy[d][1], d, depth+1);
		if(d<3)
			dfs(x+dxdy[d+1][0], y+dxdy[d+1][1], d+1, depth+1);

		visited.remove(board[x][y]);
		return;
	}
}