
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
        int dp[] = new int[12];
        dp[1] = 1;dp[2]=2; dp[3]=4;
        
        for(int i=1;i<=T; i++) {
            N = Integer.parseInt(br.readLine());
            
            if (dp[N]!=0) {
            	sb.append(dp[N]).append("\n");
            }else {
            	for(int j=1; j<=N;j++) {
            		if(dp[j]!=0) continue;
            		for(int k=j-3; k<j;k++) {
            			dp[j]+=dp[k];
            		}
            	}
            	sb.append(dp[N]).append("\n");
            	
            }
            
        }
        System.out.println(sb);
    }
}