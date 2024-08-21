import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			boolean[] saw = new boolean[10];
			int N = Integer.parseInt(br.readLine());
			int k = 1;
			while(true) {
				int sheeps = N*k;
//				System.out.println(sheeps);
				while (sheeps>0) {
					saw[sheeps%10]=true;
					sheeps/=10;
				}

//				System.out.println(Arrays.toString(saw));
				boolean allvisited = true;
				for(boolean s: saw) {
					if (!s) {
						allvisited = false;
						break;
					}
				}
				
				if(allvisited) {
					sb.append("#"+test_case+" "+(N*k)+"\n");
					break;
				}
				k++;
			}
		}
		System.out.println(sb);
	}
}