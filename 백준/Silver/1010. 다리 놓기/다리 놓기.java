import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(comb(N,M));
		}
	}
	private static long comb(int n, int m) {
		long a=1;
		for (int i = 1; i <= n; i++) {
            a = a * (m - i + 1) / i;
        }
		return a;
	}
}