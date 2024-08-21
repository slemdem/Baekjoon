import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			
			int[][] board = new int[N][N];
			
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			int[][] newboard = new int[N][N];
			switch (order) {
			case "up":
				for (int i=0; i<N;i++) {
					int ptr = 0;
					for(int j=0; j<N;j++) {
						if(board[j][i]!=0) {
							if(board[j][i]==newboard[ptr][i]) {
								newboard[ptr++][i] += board[j][i];
							}else {
								if(newboard[ptr][i]!=0) ptr++;
								newboard[ptr][i] = board[j][i];
							}
						}
					}
				}
				break;

			case "down":
				for (int i=0; i<N;i++) {
					int ptr = N-1;
					for(int j=N-1; j>=0;j--) {
						if(board[j][i]!=0) {
							if(board[j][i]==newboard[ptr][i]) {
								newboard[ptr--][i] += board[j][i];
							}else {
								if(newboard[ptr][i]!=0) ptr--;
								newboard[ptr][i] = board[j][i];
							}
						}
					}
				}
				
				break;
			case "left":
				for (int i=0; i<N;i++) {
					int ptr = 0;
					for(int j=0; j<N;j++) {
						if(board[i][j]!=0) {
							if(board[i][j]==newboard[i][ptr]) {
								newboard[i][ptr++] += board[i][j];
							}else {
								if(newboard[i][ptr]!=0) ptr++;
								newboard[i][ptr] = board[i][j];
							}
						}
					}
				}
				
				break;

			case "right":
				for (int i=0; i<N;i++) {
					int ptr = N-1;
					for(int j=N-1; j>=0;j--) {
						if(board[i][j]!=0) {
							if(board[i][j]==newboard[i][ptr]) {
								newboard[i][ptr--] += board[i][j];
							}else {
								if(newboard[i][ptr]!=0) ptr--;
								newboard[i][ptr] = board[i][j];
							}
						}
					}
				}
				
				break;
			}

			sb.append("#"+test_case+"\n");
			for(int[] a : newboard) {
				for(int i=0; i<N; i++) {
					sb.append(a[i]);
					if(i!=N-1) sb.append(" ");
					else sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}