import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
        	st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y-x;
            int cnt;
            double s = Math.sqrt(dist);
            if((int)(s) == s) {
            	cnt = (int)(s)*2-1;
            }else {
            	int a = dist - (int)s * (int)s;
            	cnt = (int)s*2 + (a-1)/(int)s;
            }
            
            System.out.println(cnt);
        }
    }
}