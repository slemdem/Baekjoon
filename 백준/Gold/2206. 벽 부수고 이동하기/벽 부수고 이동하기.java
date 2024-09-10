import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        int[][] map = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
            for(int j=0; j<M; j++) {
            	map[i][j] = -(str.charAt(j)-'0');
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        map[0][0] = 2;
        q.add(new int[] {0,0,2,1});
        
        boolean sucess = false;
        while (!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				System.out.println(cur[3]);
				sucess = true;
				break;
			}
			for(int i=0; i<4; i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				if(nx<N && nx>=0 && ny<M && ny>=0 && map[nx][ny]<cur[2]) {
					if(map[nx][ny]==-1) {
						if (cur[2]==1) continue;
						map[nx][ny] = 3;
						q.add(new int[] {nx,ny,cur[2]-1,cur[3]+1});
					}else {
						map[nx][ny] = cur[2];
						q.add(new int[] {nx,ny,cur[2],cur[3]+1});
					}
				}
			}
		}
        
        if(!sucess) System.out.println(-1);

    }
}