import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++){
            for(int j=0; j<N-i;j++){
                sb.append(" ");
            }
            for(int j=0; j<i;j++){
                sb.append("*");
            }
            for(int j=0; j<i-1;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=N-1; i>0; i--){
            for(int j=0; j<N-i;j++){
                sb.append(" ");
            }
            for(int j=0; j<i;j++){
                sb.append("*");
            }
            for(int j=0; j<i-1;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
}