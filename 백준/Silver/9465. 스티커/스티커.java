import java.util.*;
import java.io.*;

public class Main {
	static int[][] Stikers, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			Stikers = new int[N+1][2];
			dp = new int[N+1][2];
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N; j++) {
					Stikers[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			dp[1][0] = Stikers[1][0];
			dp[1][1] = Stikers[1][1];
			for(int i=2; i<=N; i++) {
				dp[i][0] = Stikers[i][0]+Math.max(Math.max(dp[i-2][0], dp[i-1][1]),dp[i-2][1]);
				dp[i][1] = Stikers[i][1]+Math.max(Math.max(dp[i-2][1], dp[i-1][0]),dp[i-2][0]);
			}
			System.out.println(Math.max(dp[N][0],dp[N][1]));
		}
	}
}
