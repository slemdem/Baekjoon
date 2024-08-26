import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] cups = new boolean[N+1];
		cups[X] = true;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cups[a]||cups[b]) {
				boolean temp = cups[a];
				cups[a] = cups[b];
				cups[b] = temp;
			}
		}
		
		for(int i=1; i<=N; i++)
			if(cups[i]) System.out.println(i);
		
	}
}