import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int T = Integer.parseInt(st.nextToken());
        int[][] dxdy = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for (int tests = 0; tests<T; tests++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	
        	int[][] field = new int[N][M];
        	boolean[][] visited = new boolean[N][M];
        	
        	for(int i = 0; i<K; i++) {
        		st = new StringTokenizer(br.readLine()," ");
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	field[x][y] = 1;
        	}
        	
        	Queue<int[]> q = new LinkedList<>();
        	int cnt=0;
        	for(int i = 0; i<N; i++) {
        		for(int j = 0; j<M; j++) {
        			if(field[i][j]==1 && !visited[i][j]) {
        				q.add(new int[] {i,j});
        				visited[i][j] = true;
        				while(!q.isEmpty()) {
        					int[] xy = q.poll();
        					for(int l = 0; l<4; l++) {
        						int nowx = xy[0]+dxdy[l][0];
        						int nowy = xy[1]+dxdy[l][1];
        						if(nowx >=0 && nowx < N && nowy >=0 && nowy < M &&field[nowx][nowy]==1 && !visited[nowx][nowy]) {
        							q.add(new int[] {nowx,nowy});
        							visited[nowx][nowy] = true;
        						}
        					}
        					
        				}
        				cnt++;
        			}
        		}
        	}
        	System.out.println(cnt);
        }
    }
}