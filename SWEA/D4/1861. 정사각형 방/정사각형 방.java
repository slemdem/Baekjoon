import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		int T;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; ++testcase)
		{
			int N = Integer.parseInt(br.readLine());
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			int[][] rooms = new int[N+2][N+2];
			for (int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j=1; j<=N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int start = 0;
			int len = 0;
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					int now = rooms[i][j];
					int nowx=i;
					int nowy=j;
					int cnt = 1;
					while (true) {
						boolean changed =false;
						for(int k=0; k<4; k++) {
							if(rooms[nowx+dx[k]][nowy+dy[k]] == now+1) {
								changed = true;
								nowx+=dx[k];
								nowy+=dy[k];
								cnt++;
								now+=1;
							}
						}
						if (!changed) break;
					}
					
					if (cnt>len) {
						len = cnt;
						start = rooms[i][j];
					}else if(cnt==len && start>rooms[i][j])
						start = rooms[i][j];
				}
			}
			sb.append("#"+testcase+" "+start+" "+len+"\n");
		}
		System.out.println(sb);
	}
}