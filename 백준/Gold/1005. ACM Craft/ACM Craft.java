import java.io.*;
import java.util.*;

public class Main {
    static int T, N, K;
    static int[] cost;
    static boolean[] visited;
    static List<List<Integer>> order;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cost = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            order = new LinkedList<>();
            for(int i =0; i < N; i++) order.add(new LinkedList<>());

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken())-1;
                int n = Integer.parseInt(st.nextToken())-1;
                order.get(n).add(p);
            }

            visited = new boolean[N];
            int i = Integer.parseInt(br.readLine())-1;

            int result = dfs(i);
            
            sb.append(result);
            if(t!=T-1) sb.append("\n");
        }

        
        System.out.println(sb.toString());
    }

    private static int dfs(int c) {
        if(visited[c]) return cost[c];

        int pre = 0;

        for(int i : order.get(c)){
            pre = Math.max(pre,dfs(i));
        }
        visited[c] = true;
        return cost[c] = pre+cost[c];
    }
}