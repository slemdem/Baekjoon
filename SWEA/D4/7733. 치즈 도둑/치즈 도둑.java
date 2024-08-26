import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
    static int[][] dxdy= {{0,-1},{-1,0},{0,1},{1,0}};
	static int[][] board;
	static boolean[][] visited;
	static int T, N, remain;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; ++testcase){
			N = Integer.parseInt(br.readLine());
			
			board = new int[N+2][N+2];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println(Arrays.deepToString(board));
			int max = 0;
			for(int d=0;d<100;d++) {
				visited = new boolean[N+2][N+2];
				int cnt = 0;
				remain = 0;
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N;j++) {
						if(board[i][j]>d&&!visited[i][j]) {
							dfs(i,j,d);
							cnt++;
						}
					}
				}
				
//				System.out.println(Arrays.deepToString(visited));
				if(cnt>max) max = cnt;
				if (max>remain) break;
			}
			sb.append("#"+testcase+" "+max+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int d) {
		visited[x][y]=true;
		remain++;
		for(int i=0; i<4; i++) {
			if(board[x+dxdy[i][0]][y+dxdy[i][1]]>d && !visited[x+dxdy[i][0]][y+dxdy[i][1]]) {
				dfs(x+dxdy[i][0],y+dxdy[i][1],d);
			}
		}
	}

}