import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int T = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> ad = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i<8; i++) {
				ad.add(Integer.parseInt(st.nextToken()));
			}

			boolean keep = true;
			while (keep) {
				for(int i=1; i<=5; i++) {
					int cur = ad.poll()-i;
					if(cur <= 0) {
						cur = 0;
						ad.add(cur);
						keep = false;
						break;
					}
					ad.add(cur);
				}
			}
			sb.append("#"+T+" ");
			
			while(ad.size()>1) {
				sb.append(ad.poll()).append(" ");
			}
			sb.append(ad.poll()).append("\n");
		}
		System.out.println(sb);
	}

}