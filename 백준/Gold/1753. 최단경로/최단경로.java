import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] edges = new ArrayList[V+1];

        for (int i=0;i<=V;i++) edges[i] = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            edges[s].add(new int[]{e,w});
        }
        int[] dij = new int[V+1];
        Arrays.fill(dij, Integer.MAX_VALUE);
        dij[K] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
        int[] cur;

        for(int[] edge: edges[K])
            pq.add(edge);
        
        int cnt=0;
        while (pq.peek() != null) {
			cur = pq.poll();
            // System.out.println(cur[0]+" "+cur[1]);
            if(dij[cur[0]]>cur[1]){
                cnt++;
                dij[cur[0]] = cur[1];
            }else continue;
            if(cnt==V-1)break;
			for(int[] edge: edges[cur[0]]){
                // System.out.println(edge[0]+" "+edge[1]+" "+cur[1]+" "+dij[edge[0]]+" "+(edge[1]+cur[1]));
                if(dij[edge[0]]>edge[1]+cur[1]){
                    edge[1]=edge[1]+cur[1];
                    // System.out.println("in"+Arrays.toString(edge));
                    pq.add(edge);
                }
            }
		}

        for(int i=1;i<=V;i++){
            if (dij[i]==Integer.MAX_VALUE) {
                sb.append("INF\n");
            }else
                sb.append(dij[i]+"\n");
        }

        System.out.println(sb);

    }
}