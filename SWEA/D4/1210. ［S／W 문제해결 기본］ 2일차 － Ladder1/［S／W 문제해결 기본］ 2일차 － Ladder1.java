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
		
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			
			int dirx=0, diry=0;
			
			for(int i= 0; i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j= 0; j<100;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]==2) {
						dirx=i;
						diry=j;
					}
				}
			}
			
			int[][] dir = {{0,-1},{0,1},{-1,0}};
			int pastx = dirx, pasty=diry;
			
			while(dirx>0) {
				for (int i = 0; i<3; i++) {
					int curx = dirx+dir[i][0];
					int cury = diry+dir[i][1];
					if (cury<0 || cury>=100) continue;
					if(arr[curx][cury]==1 &&!(curx==pastx&&cury==pasty)) {
						pastx = dirx;
						pasty = diry;
						dirx += dir[i][0];
						diry += dir[i][1];
					}
				}
			}
			
			sb.append("#"+test_case+" "+diry).append("\n");
		}
		System.out.println(sb);
	}
}