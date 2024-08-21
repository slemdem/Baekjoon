import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			long N = sc.nextLong();
			int cnt=0;
			while(N>2) {
				if(Math.sqrt(N)%1==0.0) {
					N=(long) Math.sqrt(N);
				}else {
					long until = (long) Math.pow(Math.ceil(Math.sqrt(N)),2);
					cnt += until-N-1;
					N = until;
				}
				cnt++;
			}
			
			sb.append("#"+test_case+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}