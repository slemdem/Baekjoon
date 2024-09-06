import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, p, c;
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
         
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            matrix = new int[N+1][N+1];
            
            int[] topol = new int[N+1];
            
            for (int i=0; i<M;i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            	p = Integer.parseInt(st.nextToken());
            	c = Integer.parseInt(st.nextToken());
            	
            	matrix[p][c] = 1;
            }

            int ans=0;
            for (int i=1; i<=N;i++) {
            	if(gtBFS(i)+ltBFS(i)==N-1) ans++;
            }
            
            
			sb.append("#"+test+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	private static int gtBFS(int start) {
		int cnt=0;
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[N+1];
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
        	int cur = q.poll();
        	for(int i=1;i<=N; i++) {
        		if(visited[i]||matrix[cur][i]==0) continue;
        		q.offer(i);
        		visited[i]=true;
        		cnt++;
        	}
		}
		return cnt;
		
	}
	private static int ltBFS(int start) {
		int cnt=0;
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[N+1];
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
        	int cur = q.poll();
        	for(int i=1;i<=N; i++) {
        		if(visited[i]||matrix[i][cur]==0) continue;
        		q.offer(i);
        		visited[i]=true;
        		cnt++;
        	}
		}
		return cnt;
	}
}
