import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 1; i<=N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

        	sb.append(arr[m]-arr[n-1]).append("\n");
        }
        
        System.out.println(sb);
    }
}