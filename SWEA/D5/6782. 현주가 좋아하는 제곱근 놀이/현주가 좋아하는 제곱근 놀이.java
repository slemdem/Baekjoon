import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			long N = Long.parseLong(br.readLine());
			int cnt=0;
			while(N>2) {
				if(Math.sqrt(N)%1==0.0) {
					N=(long) Math.sqrt(N);
					cnt++;
				}else {
					long until = (long) Math.pow(Math.ceil(Math.sqrt(N)),2);
					cnt += until-N;
					N = until;
				}
			}
			
			sb.append("#"+test_case+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}