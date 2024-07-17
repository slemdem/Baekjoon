import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        
        int[] cnts = new int[N+1];
        for (int i=N-1; i>=1;i--) {
        	cnts[i]= cnts[i+1]+1;
        	if(i*3<=N) {
        		cnts[i] = Math.min(cnts[i], cnts[i*3]+1);
        	}
        	if(i*2<=N) {
        		cnts[i] = Math.min(cnts[i], cnts[i*2]+1);
        	}
        }
        System.out.println(cnts[1]);
    }
}