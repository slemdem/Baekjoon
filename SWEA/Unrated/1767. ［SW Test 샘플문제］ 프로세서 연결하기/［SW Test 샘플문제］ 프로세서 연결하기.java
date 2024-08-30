import java.io.*;
import java.util.*;


class Solution {
	
	static class Core{
		int x,y;
		boolean[] direction;
		
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
			this.direction = new boolean[5];
		}
		
		public void findDirection() {
			direction[0] = true;
			for (int i = 1; i < 5; i++) {
				boolean success = true;
				int posx = x+dxdy[i][0];
				int posy = y+dxdy[i][1];
				while(posx<N && posx>=0 && posy<N && posy>=0) {
					if(maxinos[posx][posy]!=0) {
						success = false;
						break;
					}
					posx += dxdy[i][0];
					posy += dxdy[i][1];
				}
				direction[i] = success;
			}
		}
	}
	
	static int N, baseCoreConect, coreConect, min, maxinos[][];
	static ArrayList<Core> cores;
	static int[] coreDirection, dxdy[] = {{},{-1,0},{0,1},{1,0},{0,-1}};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			
			maxinos = new int[N][N];
			coreConect = 0;
			baseCoreConect = 0;
			cores = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					maxinos[i][j] = Integer.parseInt(st.nextToken());
					if(maxinos[i][j]==1) {
						if(i==0||i==N-1||j==0||j==N-1) {
							baseCoreConect++;
						}else {
							cores.add(new Core(i,j));
						}
					}
				}
			}
			
			for(Core c : cores) c.findDirection();
//			for(int i=0; i<cores.size();i++) {
//				int corex = cores.get(i).x;
//				int corey = cores.get(i).y;
//				System.out.println(corex +" "+corey+" "+Arrays.toString(cores.get(i).direction));
//			}
			
			coreDirection = new int[cores.size()];
			for(int i = 0; i<=4; i++) {
				if(!cores.get(0).direction[i]) continue;
				coreDirection[0] = i;
				if(i!=0)
					tryconnect(1,1);
				else
					tryconnect(1,0);
			}
			
			sb.append("#"+test +" "+min+"\n");
		}
		System.out.println(sb);
	}

	private static void tryconnect(int n, int con) {
		if (n==cores.size()) {
			if(con<coreConect-baseCoreConect) return;
			int conected = baseCoreConect;
			int sum = 0;
			int[][] copy = new int[N][];
			for(int i=0; i<N;i++){
				copy[i] = maxinos[i].clone();
			}
//			System.out.println(Arrays.toString(coreDirection));
			int ptr = 0;
			for (Core c : cores) {
				if(con<coreConect-baseCoreConect) return;
				int d = coreDirection[ptr++];
				if (d==0) continue;
				int posx = c.x+dxdy[d][0];
				int posy = c.y+dxdy[d][1];
				
				int cnt = 0;
				boolean success = true;
				while(posx<N && posx>=0 && posy<N && posy>=0) {
					if(copy[posx][posy]!=0) {
						posx -= dxdy[d][0];
						posy -= dxdy[d][1];
						success = false;
						con--;
						break;
					}
					copy[posx][posy] = -1;
					posx += dxdy[d][0];
					posy += dxdy[d][1];
					cnt++;
				}
				if(success) {
					conected++;
					sum+=cnt;
				}
			}
			
			if(coreConect<conected) {
//				System.out.println(conected+" "+ sum+" "+Arrays.toString(coreDirection));
				coreConect = conected;
				min = sum;
			}else if (coreConect == conected && sum<min) {
//				System.out.println(conected+" "+ sum+" "+Arrays.toString(coreDirection));
				min = sum;
			}
			
			return;
		}
		
		for(int i = 0; i<=4; i++) {
			if(!cores.get(n).direction[i]) continue;
			coreDirection[n] = i;
			if(i!=0)
				tryconnect(n+1,con+1);
			else
				tryconnect(n+1,con);
		}
	}

}