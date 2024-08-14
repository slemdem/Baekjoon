import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N+1][N+1];
        
        for(int i = 1; i<=N;i++) {
        	st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j<=N;j++) {
            	area[i][j] = Integer.parseInt(st.nextToken());
            	area[i][j] += area[i-1][j]+area[i][j-1]-area[i-1][j-1];
        	}
        }
        
        for (int i = 0; i<M;i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	
        	sb.append(area[x2][y2] - area[x1-1][y2] -(area[x2][y1-1]-area[x1-1][y1-1])).append("\n");
        		
        }
        
        System.out.println(sb);
    }
	
}