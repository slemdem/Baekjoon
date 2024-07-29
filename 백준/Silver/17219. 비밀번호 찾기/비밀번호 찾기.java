import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> ids = new HashMap<>();

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String site = st.nextToken();
            String id = st.nextToken();
        	ids.put(site,id);
        }
        for (int i = 0; i<M; i++) {
        	 sb.append(ids.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}