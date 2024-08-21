import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean isBitOn = true;
			for(int i=0; i<N; i++) {
				if ((M&1<<i)==0) {
					isBitOn = false;
					break;
				}
			}
			if (isBitOn)
				sb.append("#"+test_case+" ON\n");
			else
				sb.append("#"+test_case+" OFF\n");
		}
		System.out.println(sb);
	}
}