import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans;
	static boolean[] visited;
	static int[][] synergy;
	static int maxv, minv;

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++){
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					synergy[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			
			for(int i=0; i<=N/2;i++) {
				visited[i]=true;
				cal(1,i+1);
				visited[i]=false;
			}
			System.out.println("#" + test_case + " " + ans);
		}

	}


	private static void cal(int cnt, int start) {
		if (cnt== N/2) {
//			System.out.println(Arrays.toString(visited));
			int[] vis = new int[cnt];
			int[] nonvis = new int[cnt];
			
			int vp = 0, nvp = 0;
			for(int i=0; i<N;i++) {
				if(visited[i])
					vis[vp++] = i;
				else 
					nonvis[nvp++] = i;
			}
			
			vp = 0;
			for(int i=0; i<cnt; i++) {
				for(int j = 0; j<cnt; j++)
					vp+=synergy[vis[i]][vis[j]];
			}
			
			nvp = 0;
			for(int i=0; i<cnt; i++) {
				for(int j = 0; j<cnt; j++)
					nvp+=synergy[nonvis[i]][nonvis[j]];
			}
			
			ans= Math.min(ans,(int) Math.abs(vp-nvp));
			return;
		}
		
		for(int i=start; i<N; i++) {
			visited[i]=true;
			cal(cnt+1,i+1);
			visited[i]=false;
		}
		
	}
	 
	
}