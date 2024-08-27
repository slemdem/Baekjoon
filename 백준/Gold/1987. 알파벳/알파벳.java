import java.io.*;
import java.util.*;

class Main
{
    static int[][] dxdy= {{0,-1},{-1,0},{0,1},{1,0}};
	static char[][] board;
	static int T, N, remain;
	static HashSet<Character> ad;
	public static void main(String[] args) throws Exception
	{
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
		ad = new HashSet<>();
		ad.add(board[1][1]);
		System.out.println(dfs(1,1));
	}

	private static int dfs(int x, int y) {
		int m = ad.size();
		for(int i=0; i<4; i++) {
			int curx = x+dxdy[i][0];
			int cury = y+dxdy[i][1];
			if(board[curx][cury]=='\u0000') continue;
			if (ad.contains(board[curx][cury])) continue;
			
			ad.add(board[curx][cury]);
			m =Math.max(m,dfs(curx,cury));
			ad.remove(board[curx][cury]);
		}
		
		return m;
	}

}