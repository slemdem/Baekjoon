import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1000000000;
    static int N;
    static int[][][] dp; // [자리][끝자리][마스크]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10][1 << 10];

        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);

        int result = 0;
        for (int i = 1; i <= 9; i++) {
            result = (result + dfs(1, i, 1 << i)) % MOD;
        }

        System.out.println(result);
    }

    static int dfs(int len, int pre, int mask) {
        if (len == N) {
            return (mask == (1 << 10) - 1) ? 1 : 0;
        }

        if (dp[len][pre][mask] != -1) return dp[len][pre][mask];

        int total = 0;

        if (pre > 0)
            total = (total + dfs(len + 1, pre - 1, mask | (1 << (pre - 1)))) % MOD;

        if (pre < 9)
            total = (total + dfs(len + 1, pre + 1, mask | (1 << (pre + 1)))) % MOD;

        return dp[len][pre][mask] = total;
    }
}