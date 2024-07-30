import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int dist = M-N;
        int maxs = (int)Math.sqrt(dist);
        
        int grow = 0;
        int cnt = 0;
        for(int i=1;i<=maxs; i++) {
        	grow +=i;
        	cnt++;
        }

        if(grow==dist) {
        	System.out.println(cnt);
        }else {
	        for(int i=maxs-1; i>=1; i--) {
	        	grow +=i;
	        	cnt++;
	        }
			if(grow<dist) {
				dist -= grow;
			    if (dist>maxs) {
			    	cnt+=2;
			    }else if(dist>0) {
			    	cnt++;
			    }
				System.out.println(cnt);
	        }else {
	            System.out.println(cnt);
	        }
        }
    }
}