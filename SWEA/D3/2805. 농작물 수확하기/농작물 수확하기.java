import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static int[][] farm;
	
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++){
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String st = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j]=st.charAt(j)-'0';
				}
			}
			
			ans = 0;
			int a = N/2;
			for(int i=0; i<N;i++) {
				for(int j= Math.abs(a-i); j<N-Math.abs(a-i);j++) {
					ans+=farm[i][j];
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}