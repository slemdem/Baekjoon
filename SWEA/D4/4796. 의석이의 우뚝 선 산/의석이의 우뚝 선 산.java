import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static int[] area;
	
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		//st = new StringTokenizer(br.readLine());
		
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			area = new int[N];
			
			for(int i = 0; i < N; i++) {
				area[i]=sc.nextInt();
			}
			
			ans = 0;
			for(int i=1; i<N-1;i++) {
				ans += isStanding(i,i-1,i+1);
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}


	private static int isStanding(int i,int x,int y) {
		if(x<0||y>N) return 0;
			
		int cnt=0;
		
		if(area[x]<area[i]&& area[y]<area[i]) {
			int xcnt=1;
			int ycnt=1;
			
			while(x-1>=0 && area[x-1]<area[x]) {
				x--;
				xcnt++;
			}
			
			while(y+1<N && area[y+1]<area[y]) {
				y++;
				ycnt++;
			}
			if (xcnt==1&&ycnt==1) return 1;
			
			return xcnt*ycnt;
		}
		return 0;
	}
}