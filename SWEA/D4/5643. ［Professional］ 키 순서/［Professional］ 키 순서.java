import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, p, c, cnt;
    static int[][] adjMatrix,radMatrix;
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

            adjMatrix = new int[N+1][N+1];
            radMatrix = new int[N+1][N+1];
            
            for (int i=0; i<M;i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            	p = Integer.parseInt(st.nextToken());
            	c = Integer.parseInt(st.nextToken());
            	
            	adjMatrix[p][c] = 1;
            }
            for (int i=1; i<=N;i++) {
            	adjMatrix[i][0]=-1;
            }

            int ans=0;
            for (int i=1; i<=N;i++) {
        		if(adjMatrix[i][0]!=-1) continue;
            	gtDFS(i);
            }
            

            for (int i=1; i<=N;i++) {
                for (int j=1; j<=N;j++) {
                	adjMatrix[0][j] += adjMatrix[i][j];
                }
            }
            
            for (int i=1; i<=N;i++) {
        		if(adjMatrix[i][0]+adjMatrix[0][i] ==N-1) ans++;
            }
            
			sb.append("#"+test+" "+ans+"\n");
		}
		System.out.println(sb);
	}
    
	private static void gtDFS(int cur) {
        for(int i=1;i<=N; i++) {
    		if(adjMatrix[cur][i]==0) continue;
    		if(adjMatrix[i][0]==-1) {
    			gtDFS(i);
    		}

    		if(adjMatrix[i][0]>0) {
    			for(int j=1; j<=N; j++) {
    				if(adjMatrix[i][j] != 0) adjMatrix[cur][j] = 1;
    			}
    		}
		}
        
        adjMatrix[cur][0] = 0;
        for(int k=1; k<=N; k++) {
			adjMatrix[cur][0] += adjMatrix[cur][k];
		}
		
	}
	
}
