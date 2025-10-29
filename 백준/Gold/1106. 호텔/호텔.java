import java.io.*;
import java.util.*;

public class Main {
    static int C, N, INF = 1000000;
    static int[][] ad;
    static int[] dp;
    static List<List<Integer>> order;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ad = new int[N][];

        int maxvalue = 0;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            ad[n] = new int[] {cost, value};
            maxvalue = Math.max(maxvalue, value);
        }


        dp = new int[C+maxvalue];

        Arrays.fill(dp, INF);

        for (int i = 0; i < N; i++) {
            dp[ad[i][1]] = Math.min(dp[ad[i][1]], ad[i][0]);
            for (int j = ad[i][1]; j < C+maxvalue; j++) {
                dp[j] = Math.min(dp[j-ad[i][1]]+ad[i][0], dp[j]);
            }
        }

        int result = INF;
        for (int i=C; i<C+maxvalue; i++)
            result = Math.min(result, dp[i]);

        System.out.println(result);
    }

}