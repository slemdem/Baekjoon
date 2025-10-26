import java.io.*;
import java.util.*;

public class Main {
    static int N, Full, INF = Integer.MAX_VALUE;
    static int[][] City, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        City = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                City[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Full = (1 << N) - 1;
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        
        int minCost = travel(0, 0, 1 << 0);
        
        System.out.println(minCost);
    }

    public static int travel(int root, int cur, int mask){
        if (mask == Full){
            return City[cur][root] == 0 ? INF : City[cur][root];
        }

        int cache = dp[cur][mask];
        if (cache != -1) return cache;

        int best= INF;
        for (int next = 0; next < N; next++){
            if ((mask & (1 << next)) != 0) continue;
            if (City[cur][next] == 0) continue;
            
            int sub = travel(root, next, mask | (1 << next));
            if (sub == INF) continue;
            
            best = Math.min(best, City[cur][next] + sub);
        }

        return dp[cur][mask] = best;
    }
}