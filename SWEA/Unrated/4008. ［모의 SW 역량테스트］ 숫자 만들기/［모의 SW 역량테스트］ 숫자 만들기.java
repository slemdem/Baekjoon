import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[] cals, nums, used;
	static int maxv, minv;
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			
			maxv = Integer.MIN_VALUE;
			minv = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			cals = new int[4];
			for(int i = 0; i < 4; i++) 
				cals[i] = Integer.parseInt(st.nextToken());
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			used= new int[4];
			cal(1,nums[0]);
			
			int ans = maxv-minv;
			System.out.println("#" + test_case + " " + ans);
		}
	}

	private static void cal(int cnt, int val) {
		if (cnt>= N) {
//			System.out.println(val);
			if (val>maxv) maxv=val;
			if (val<minv) minv=val;
		}
		for(int i=0; i<4; i++) {
			if(used[i]<cals[i]) {
				used[i]+=1;
				switch (i) {
				case 0:
					cal(cnt+1,val+nums[cnt]);
					break;
				case 1:
					cal(cnt+1,val-nums[cnt]);
					break;
				case 2:
					cal(cnt+1,val*nums[cnt]);
					break;
				case 3:
					cal(cnt+1,val/nums[cnt]);
					break;

				default:
					break;
				}
				used[i]-=1;
			}
		}
	}
}