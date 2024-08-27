import java.io.*;
import java.util.*;

public class Main {
	static int[][] dxdy= {{0,-1},{-1,0},{0,1},{1,0}};
	static int[][] board;
	static boolean[][] visited;
	static int N, M, remain, preRemain;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		remain = countBfs();
		preRemain = remain;
		int count = 0;
		while(remain>0) {
			visited = new boolean[N][M];
			deletedfs(0,0);
			remain = countBfs();
			if (remain!=0) preRemain = remain;
			count++;
		}
		System.out.println(count);
		System.out.println(preRemain);
	}

	private static int countBfs() {
		Deque<int[]> dq = new LinkedList<>();
		int cnt = 0;
		for (int i=0; i<N;i++) {
			for (int j=0; j<M; j++) {
				if (board[i][j]==1&& !visited[i][j]) {
					dq.add(new int[]{i,j});
					visited[i][j] = true;
					while(!dq.isEmpty()) {
						int[] now = dq.pollFirst();
						cnt++;
						for(int k=0; k<4; k++) {
							int nextx = now[0]+dxdy[k][0];
							int nexty = now[1]+dxdy[k][1];
							if(board[nextx][nexty]==1&& !visited[nextx][nexty]) {
								dq.add(new int[]{nextx,nexty});
								visited[nextx][nexty] = true;
							}
						}
					}
				}
			}
		}
		return cnt;
	}

	private static void deletedfs(int x, int y) {
		Deque<int[]> melt = new LinkedList<>();
		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[]{x,y});
		while(!dq.isEmpty()) {
			int[] cord = dq.pollFirst();
			for(int i=0; i<4; i++) {
				int nextx = cord[0]+dxdy[i][0];
				int nexty = cord[1]+dxdy[i][1];
				if(nextx<N && nextx>=0 && nexty<M && nexty>=0) {
					if(board[nextx][nexty]==1 && !visited[nextx][nexty]) {
						melt.add(new int[] {nextx, nexty});
						visited[nextx][nexty] = true;
					}else if(!visited[nextx][nexty]){
						dq.add(new int[] {nextx, nexty});
						visited[nextx][nexty] = true;
					}
				}
			}
		}
		while(!melt.isEmpty()) {
			int[] cord = melt.pollFirst();
			board[cord[0]][cord[1]] = 0;
		}
		
	}
}