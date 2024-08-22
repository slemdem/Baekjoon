import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int day, month, month3, year;
	static int[] plan;
	public static void main(String[] args) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; ++testcase)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			plan = new int[12];
			for (int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = Math.min(price(0),year);
			sb.append("#"+testcase+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
	public static int price(int cnt) {
		if (cnt>=12) return 0;
		if (plan[cnt]==0) return price(cnt+1);
		return Math.min(price1(cnt)+price(cnt+1), price3(cnt)+price(cnt+3));
	}
	
	public static int price1(int cnt) {
		if (cnt>=12) return 0;
		return Math.min(plan[cnt]*day, month);
	}
	
	public static int price3(int cnt) {
		int sum=0;
		for (int i=0;i<3;i++){
			sum+=price1(cnt+i);
            if (sum>month3) return month3;
        }
		return sum;
	}
}