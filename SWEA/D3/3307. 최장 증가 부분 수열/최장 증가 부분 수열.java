import java.util.*;
import java.io.*;

public class Solution {
	static int N;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
            N = Integer.parseInt(br.readLine());
            
            int[] arr = new int[N+1];
            int[][] dp = new int[N+1][N+1];
        	st = new StringTokenizer(br.readLine(), " ");
            for(int n=1; n<=N;n++) {
            	arr[n] = Integer.parseInt(st.nextToken());
            	dp[0][n] = Math.min(dp[0][n-1]!=0?dp[0][n-1]:Integer.MAX_VALUE, arr[n]);
            }
            
            for(int i=1; i<=N; i++) {
            	for (int j=i; j<=N; j++) {
            		if(dp[i-1][j]!=0&&dp[i-1][j]<arr[j]) {
            			dp[i][j] =  Math.min(dp[i][j-1]!=0?dp[i][j-1]:Integer.MAX_VALUE, arr[j]);
            		}else {
            			if(dp[i][j-1]==0) continue;
            			dp[i][j] = dp[i][j-1];
            		}
            	}
            }
//            System.out.println(Arrays.deepToString(dp));

            int ans=0;
            for (int i=0; i<N;i++) {
            	if(dp[i][N]==0) {
            		ans= i;
            		break;
            	}
            }
            
            
			sb.append("#"+test+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
}