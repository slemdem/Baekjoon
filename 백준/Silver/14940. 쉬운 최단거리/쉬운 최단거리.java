import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x;
	int y;
	int time;
	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
	@Override
	public int compareTo(Node o) {
		return (this.time - o.time);
	}
}

public class Main {
	static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int ox=0,oy=0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()," ");
        	for (int j = 0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 2) {
        			ox = i;
        			oy = j;
        		}else if(map[i][j] == 1) map[i][j] =-1;
        	}
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node cur;
        
        pq.add(new Node(ox,oy,0));
        visited[ox][oy] = true;
        map[ox][oy] = 0;
        
        while (pq.peek() != null) {
			cur = pq.poll();
			map[cur.x][cur.y] = cur.time;
			for(int k = 0; k < 4; k++) {
				int curx = cur.x+dxdy[k][0];
				int cury = cur.y+dxdy[k][1];
				if (curx >= 0 && curx < N && cury >= 0 && cury < M && map[curx][cury]!=0 && !visited[curx][cury]) {
					pq.add(new Node(curx, cury, cur.time+1));
					visited[curx][cury]=true;
				}
			}
		}

        StringBuilder sb;
        for (int i=0; i<N; i++) {
        	sb = new StringBuilder();
        	for (int j = 0; j<M; j++) {
        		sb.append(map[i][j]);
        		if(j!=M-1)sb.append(" ");
        	}
        	System.out.println(sb);
        }
    }
}