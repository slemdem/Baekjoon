import java.io.*;
import java.util.*;

public class Main {
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibonacciMod(n));
    }

    public static long fibonacciMod(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[][] A = {{1, 1}, {1, 0}};
        long[][] result = matrixPow(A, n-1);

        return result[0][0];
    }

    private static long[][] matrixMult(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        C[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % MOD;
        C[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % MOD;
        C[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % MOD;
        C[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % MOD;
        return C;
    }

    private static long[][] matrixPow(long[][] A, long n) {
        long[][] result = {{1, 0}, {0, 1}};  // 단위 행렬로 초기화

        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMult(result, A);
            }
            A = matrixMult(A, A);
            n /= 2;
        }

        return result;
    }
}