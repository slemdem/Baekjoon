import java.io.*;
import java.util.*;


public class Main {
    static int N, M, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pre = -1;

            for (int v = 0; v < n; v++) {
                int cur = Integer.parseInt(st.nextToken())-1;
                if (v==0) {
                    pre = cur;
                    continue;
                }
                
                if (!graph.get(cur).contains(pre)) {
                    graph.get(cur).add(pre);
                    indegree[cur]++;
                }
                pre = cur;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) if(indegree[i]==0) que.offer(i);
            
        while (!que.isEmpty()) {
            int cur = que.poll();
            sb.append(cur+1).append("\n");
            count++;

            for (int i = 0; i < graph.size(); i++) {
                List<Integer> r = graph.get(i);
                if(r.contains(cur))
                    if (--indegree[i] == 0) que.add(i);
            }
        }

        if(count == N)
            System.out.println(sb);
        else System.out.println(0);
    }

}