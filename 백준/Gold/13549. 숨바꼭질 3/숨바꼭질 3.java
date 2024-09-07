import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
        int[] cur;

        pq.add(new int[]{N,0});
        
        while (pq.peek() != null) {
			cur = pq.poll();
			if (cur[0] == M) {
				System.out.println(cur[1]);
				break;
			}
			if(cur[0]+1 <=100000 && cur[1]+1<visited[cur[0]+1]) {
                pq.add(new int[]{cur[0]+1,cur[1]+1});
                visited[cur[0]+1] = cur[1]+1;
            }
            if(cur[0]-1 >=0 && cur[1]+1<visited[cur[0]-1]) {
                pq.add(new int[]{cur[0]-1, cur[1]+1});
                visited[cur[0]-1] = cur[1]+1;
            }
            if(cur[0]*2 <=100000 && cur[1]<visited[cur[0]*2] ) {
                pq.add(new int[]{cur[0]*2, cur[1]});
                visited[cur[0]*2] = cur[1];
            }
		}
    }
}