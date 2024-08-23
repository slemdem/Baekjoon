import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	static int[] end, cordinate[];
	static boolean[] visitied;
	static int T, N, min;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; ++testcase){
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] start = new int[2];
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			end = new int[2];
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			cordinate = new int[N][2];
			visitied = new boolean[N];
			for(int i=0; i<N;i++) {
				cordinate[i][0] = Integer.parseInt(st.nextToken());
				cordinate[i][1] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;

			findroute(start[0],start[1],0,0);
			sb.append("#"+testcase+" "+min+"\n");
		}
		System.out.println(sb);
	}

	private static void findroute(int x, int y, int d, int len) {
		if (d==N) {
			len+=Math.abs(x-end[0])+Math.abs(y-end[1]);
			min = Math.min(min, len);
			return;
		}
		
		for(int i =0; i<N;i++) {
			if (visitied[i]) continue;
			
			visitied[i] = true;
			int nextlen = Math.abs(x-cordinate[i][0]) + Math.abs(y-cordinate[i][1]);
			findroute(cordinate[i][0],cordinate[i][1],d+1,len+nextlen);
			visitied[i] = false;
		}
	}
}