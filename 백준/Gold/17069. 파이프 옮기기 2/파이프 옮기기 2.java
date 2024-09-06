import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			map[0][i] =1;
			map[i][0] =1;
		}
		
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new long[N+1][N+1][3];
		
		dp[1][2][0]=1;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if(map[i][j]==1||(i==1&&j==1)) continue;
				dp[i][j][0] += dp[i][j-1][0];
				dp[i][j][0] += dp[i][j-1][1];
				
				dp[i][j][2] += dp[i-1][j][1];
				dp[i][j][2] += dp[i-1][j][2];
				
				if(map[i-1][j]==0 && map[i][j-1]==0) {
					dp[i][j][1] += dp[i-1][j-1][0];
					dp[i][j][1] += dp[i-1][j-1][1];
					dp[i][j][1] += dp[i-1][j-1][2];
				}
			}
		}
		
		long result = 0;
		for (int i=0; i<3; i++)
			result+=dp[N][N][i];
		System.out.println(result);
	}
}
