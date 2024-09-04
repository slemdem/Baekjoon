import java.util.*;
import java.io.*;

public class Solution {
	static int day, month, month3, year;
    static int[] plan;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
         
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            month3 = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine(), " ");
            plan = new int[12];
            int[] price1= new int[12];
            for (int i=0; i<12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
                if(plan[i]*day>month) price1[i] = month;
                else price1[i] =plan[i]*day;
            }
            
            int[] price3 = new int[13];
            for (int i=1; i<=12; i++) {
            	price3[i]= price3[i-1]+price1[i-1];
                if(i>=3) price3[i] = Math.min(price3[i-3]+month3,price3[i]);
            }
            int result = Math.min(price3[12],year);
			sb.append("#"+test+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
}
