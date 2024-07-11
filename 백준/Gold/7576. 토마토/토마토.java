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
        
        int[][] tomatoes = new int[M][N];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
        	for (int j = 0; j<N; j++) {
        		tomatoes[i][j] = Integer.parseInt(st.nextToken());
        	}
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node cur;
        
        int time = 0;
        for (int i=0; i<M; i++) {
        	for (int j = 0; j<N; j++) {
        		if(tomatoes[i][j]==1) {
        	        pq.add(new Node(i,j,0));
        		}
        	}
        }
        
        while (pq.peek() != null) {
			cur = pq.poll();
			time = Math.max(time, cur.time);
			for(int k = 0; k < 4; k++) {
				int curx = cur.x+dxdy[k][0];
				int cury = cur.y+dxdy[k][1];
				if (curx >= 0 && curx < M && cury >= 0 && cury < N && tomatoes[curx][cury]==0) {
					pq.add(new Node(curx, cury, cur.time+1));
					tomatoes[curx][cury]=1;
				}
			}
		}
        boolean iscomplete = true; 
        for (int i=0; i<M; i++) {
        	for (int j = 0; j<N; j++) {
        		if(tomatoes[i][j]==0) {
        			iscomplete = false;
        		}
        	}
        }
        
        if(iscomplete)System.out.println(time);
        else System.out.println(-1);
    }
}