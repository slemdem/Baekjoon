import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuffer sb = new StringBuffer();
    static int N,M; 
    static int[] dx={-1,1,0,0},dy={0,0,-1,1}; 
    // public static int dfs(int x,int y,int sum){
    //     System.out.printf("%d %d %d %d\n",arr[x][y], x,y,sum);
    //     if(x>=0 && x<101 && y>=0 && y<101 && arr[x][y]==1){
    //         sum++;
    //         arr[x][y]=2;
    //         if (x+1<101) sum=dfs(x+1,y,sum);
    //         if (y+1<101) sum=dfs(x,y+1,sum);
    //     }
    //     return sum;
    // }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N==0) break;

            int[][] map = new int[N][N];

            for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            boolean[][] visited = new boolean[N][N];
            int result = 0;
            PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
            q.offer(new int[]{0,0,map[0][0]});
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int[] pos = q.poll();
                if(pos[0]==N-1&&pos[1]==N-1){
                    sb.append("Problem "+T+": "+pos[2]+"\n");
                    break;
                }

                for(int i=0;i<4;i++){
                    int nx = pos[0]+dx[i];
                    int ny = pos[1]+dy[i];
                    if(nx<N && nx>=0 && ny<N && ny>=0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, pos[2]+map[nx][ny]});
                    }
                }
            }
            T++;
        }
        System.out.print(sb);
    }
}