import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        int N;
        
        for (int t = 0; t<T; t++) {
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
    		int[][] counts =new int[Math.max(2, N+1)][2];
            counts[0][0] = 1;
    		counts[1][1] = 1;
    		for(int i =2; i <=N; i++) {
    			counts[i][0]+=counts[i-1][0];
    			counts[i][1]+=counts[i-1][1];
    			counts[i][0]+=counts[i-2][0];
    			counts[i][1]+=counts[i-2][1];
    		}
    		sb.append(counts[N][0]).append(" ").append(counts[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}