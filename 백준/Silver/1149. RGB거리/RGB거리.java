import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][]	colorCost = new int[N+1][3];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<3; j++) {
				colorCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][]	dp = new int[N+1][3];
		for (int j=0; j<3; j++) {
			dp[1][j] = colorCost[1][j];
		}
		int min = 0;
		for (int i=2; i<=N; i++) {
			for (int j=0; j<3; j++) {
				min = Integer.MAX_VALUE;
				for (int k=0; k<3; k++) {
					if(j!=k && min>dp[i-1][k]) min =dp[i-1][k];
				}
				dp[i][j] = min+colorCost[i][j];
			}
		}
		min = Integer.MAX_VALUE;
		for (int j=0; j<3; j++) {
			if(min>dp[N][j]) min = dp[N][j];
		}
		
		System.out.println(min);
	}
}
