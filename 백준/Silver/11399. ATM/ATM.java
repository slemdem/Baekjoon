import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        
        int[] waits = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i<N; i++) {
        	waits[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(waits);
        int total= 0;
        int waiting = 0;
        for (int i = 0; i<N; i++) {
        	total += waiting+waits[i];
        	waiting +=waits[i];
        }
        System.out.println(total);
    }
}