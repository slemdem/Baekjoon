import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x;
	int time;
	public Node(int x, int time) {
		this.x = x;
		this.time = time;
	}
	@Override
	public int compareTo(Node o) {
		return (this.time - o.time);
	}
}

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node cur;
        
        pq.add(new Node(N,0));
        
        while (pq.peek() != null) {
			cur = pq.poll();
			if (cur.x == M) {
				System.out.println(cur.time);
				break;
			}
			for(int k = 0; k < 4; k++) {
				if(cur.x+1 <=100000 && !visited[cur.x+1]) {
					pq.add(new Node(cur.x+1, cur.time+1));
					visited[cur.x+1] = true;
				}
				if(cur.x-1 >=0 && !visited[cur.x-1]) {
					pq.add(new Node(cur.x-1, cur.time+1));
					visited[cur.x-1] = true;
				}
				if( cur.x*2 <=100000 && !visited[cur.x*2] && cur.x < M ) {
					pq.add(new Node(cur.x*2, cur.time+1));
					visited[cur.x*2] = true;
				}
			}
		}
    }
}