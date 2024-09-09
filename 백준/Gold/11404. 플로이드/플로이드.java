import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int INF = 100001*V;

        int[][] fluid = new int[V+1][V+1];

        for (int i=0;i<=V;i++) {
        	for(int j=1;j<=V;j++){
        		if(i==j)fluid[i][j] = 0;
        		else fluid[i][j] = INF;
        	}
        }
        
        for(int i=0;i<E;i++){
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(fluid[s][e]>w) {
            	fluid[s][e] = w;
            }
        }
        
    	for(int k=1;k<=V;k++){
	        for(int i=1;i<=V;i++){
	        	for(int j=1;j<=V;j++){
	        		if(fluid[k][j]==INF||fluid[i][k]==INF) continue;
            		fluid[i][j] = Math.min(fluid[i][j],fluid[i][k]+fluid[k][j]);
            	}
        	}
        }

        for(int i=1;i<=V;i++){
        	for(int j=1;j<=V;j++){
	            if (fluid[i][j]==INF) {
	                sb.append("0 ");
	            }else
	                sb.append(fluid[i][j]+" ");
        	}
        	sb.append("\n");
        }

        System.out.println(sb);

    }
}