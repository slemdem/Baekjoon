import java.io.*;
import java.util.*;

class Main
{
    static int[][] dxdy= {{0,-1},{-1,0},{0,1},{1,0}};
	static char[][] board;
	static boolean[][] visited;
	static int T, N, remain;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new char[N+2][M+2];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				board[i][j] = str.charAt(j-1);
			}
		}
		visited = new boolean[N+2][M+2];
		HashSet<Character> ad = new HashSet<>();
		ad.add(board[1][1]);
		System.out.println(dfs(1,1,ad));
	}

	private static int dfs(int x, int y, HashSet<Character> ad) {
		visited[x][y]=true;
		int m = ad.size();
		for(int i=0; i<4; i++) {
			if(board[x+dxdy[i][0]][y+dxdy[i][1]]=='\u0000') continue;
			if (ad.contains(board[x+dxdy[i][0]][y+dxdy[i][1]])) continue;
			
			ad.add(board[x+dxdy[i][0]][y+dxdy[i][1]]);
			m =Math.max(m,dfs(x+dxdy[i][0],y+dxdy[i][1],ad));
			ad.remove(board[x+dxdy[i][0]][y+dxdy[i][1]]);
		}
		
		return m;
	}

}