import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a);

        int good = 0;
        long pre = Long.MIN_VALUE;
        boolean preWasGood = false;

        for (int i = 0; i < N; i++) {
            long target = a[i];
            if (target == pre) {
                if(preWasGood) good++;
                continue;
            }

            pre = target;
            preWasGood = false;
            int lp = 0, rp = N - 1;

            while (lp < rp) {
                if (lp == i) { lp++; continue; }
                if (rp == i) { rp--; continue; }
                
                long sum = a[lp] + a[rp];
                if (sum == target) {
                    good++;
                    pre = target;
                    preWasGood = true;
                    break;
                } else if (sum < target) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        System.out.println(good);
    }
}