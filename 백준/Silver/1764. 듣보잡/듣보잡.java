import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] nonheard = new String [N];
        String[] nonsaw = new String [M];

        String[] nonheardandsaw = new String [Math.max(N, M)];
        
        for(int i = 0; i<N; i++) {
        	nonheard[i] = br.readLine();
        }
        for(int i = 0; i<M; i++) {
        	nonsaw[i] = br.readLine();
        }
        
        
        Arrays.sort(nonsaw);
        Arrays.sort(nonheard);

        int cnt =0;
        int j = 0;
        for (int i = 0; i<M; i++) {
        	while(nonsaw[i].compareTo(nonheard[j])>0) {
        		if(j<N-1) j++;
        		else break;
        	}
        	if(nonsaw[i].equals(nonheard[j])) {
        		nonheardandsaw[cnt] = nonheard[j];
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
        for (int i = 0; i<cnt; i++) {
        	System.out.println(nonheardandsaw[i]);
        }
    }
}