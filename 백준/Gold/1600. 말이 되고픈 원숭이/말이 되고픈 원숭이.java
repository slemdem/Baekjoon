import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dxdy = {{-1,0},{1,0},{0,1},{0,-1}}, 
			horse = {{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for (int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<W; j++) 
				map[i][j] = -Integer.parseInt(st.nextToken());
		}
		PriorityQueue<int[]> pQue = new PriorityQueue<>((o1, o2)->o1[3]-o2[3]);
		
		pQue.offer(new int[] {0,0,K+1,0});
		boolean arrive =false;
		while (!pQue.isEmpty()) {
			int[] cur = pQue.poll();
			
			if(cur[0]==H-1&&cur[1]==W-1) {
				System.out.println(cur[3]);
				arrive = true;
				break;
			}
//			System.out.println(cur[0]+" "+cur[1]);
			for(int d=0; d<4; d++) {
				int nx = cur[0] +dxdy[d][0];
				int ny = cur[1] +dxdy[d][1];
				if(nx<H && nx>=0 && ny<W && ny>=0 && map[nx][ny]!=-1 && map[nx][ny]<cur[2]) {
					pQue.offer(new int[] {nx,ny,cur[2],cur[3]+1});
					map[nx][ny] = cur[2];
				}
			}
			
			if(cur[2]>1) {
				for(int h=0; h<8; h++) {
					int nx = cur[0] +horse[h][0];
					int ny = cur[1] +horse[h][1];
					if(nx<H && nx>=0 && ny<W && ny>=0 && map[nx][ny]!=-1 && map[nx][ny]<cur[2]-1) {
						pQue.offer(new int[] {nx,ny,cur[2]-1,cur[3]+1});
						map[nx][ny] = cur[2]-1;
					}
				}
			}
		}
		
		if(!arrive) System.out.println(-1);
	}
}