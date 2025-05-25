import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringBuffer sb;
	static int N;
	static long[] liquids;
	static long[] result = new long[3];

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		liquids = new long[N];
		for (int i = 0; i < N; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquids);

		long min = Long.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = liquids[i] + liquids[left] + liquids[right];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					result[0] = liquids[i];
					result[1] = liquids[left];
					result[2] = liquids[right];
				}
				if (sum < 0) left++;
				else right--;
			}
		}

		Arrays.sort(result);
		System.out.println(result[0] + " " + result[1] + " " +result[2]);
	}
}