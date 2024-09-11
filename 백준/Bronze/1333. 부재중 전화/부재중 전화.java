import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int cur = 0, d = D;
		boolean connected = false;
		for(int t = 1; t <= N; t++) {
			cur+=L;
			int call = 1;
			while(d<cur+5) {
				if(d>=cur) {
					connected = true;
					break;
				}
				d=D*call++;
			}
			cur+=5;
			if(connected)
				break;		
        }
		if (connected) System.out.println(d);
		else {
			if ((L+5)*N-5<=d-D)
				System.out.println(d-D);
			else System.out.println(d);
		}

	}
}