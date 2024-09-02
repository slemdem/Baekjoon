import java.io.*;
import java.util.*;

class Solution {
	
	static int N, M, C;
	static int[][] beePot, dxdy = {{},{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static int getHonney(int x, int y) {
		int honney = 0;
		int[] honneys = new int[M];
		for(int k=0; k<M;k++) {
			honney += beePot[x][y+k];
			honneys[k] = beePot[x][y+k];
		}
		int sum = 0;
		if (honney<=C) {
			for(int h:honneys) {
				sum += h*h;
			}
		}else {
			visited = new boolean[M];
			sum = honneysubset(honneys, 0, 0, 0);
		}
		return sum;
	}
	
	private static int honneysubset(int[] honneys,int sum, int psum, int depth) {
		if (sum>C) return 0;
		if (depth==M) return psum;
		visited[depth] = true;
		int a = honneysubset(honneys,sum+honneys[depth], psum+(honneys[depth]*honneys[depth]), depth+1);
		visited[depth] = false;
		int b = honneysubset(honneys, sum, psum, depth+1);
		return Math.max(a,b);
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			beePot = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					beePot[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] maxs = new int[2];
			int[][] maxsD = new int[2][2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					int s = getHonney(i, j);
					if(maxs[1]<s) {
						if(maxsD[1][0]!=i) {
							maxs[0] = maxs[1];
							maxsD[0] = maxsD[1];
							maxs[1] = s;
							maxsD[1] = new int[] {i,j};
						}else {
							maxs[1] = s;
							maxsD[1] = new int[] {i,j};
						}
					}else if(maxsD[1][0]!=i && maxs[0]<s) {
						maxs[0] = s;
						maxsD[0] = new int[] {i,j};
					}
				}
			}
			sb.append("#"+test+" "+(maxs[0]+maxs[1])+"\n");
		}
		System.out.println(sb);
	}

}