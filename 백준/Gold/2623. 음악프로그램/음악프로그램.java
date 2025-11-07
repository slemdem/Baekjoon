import java.io.*;
import java.util.*;


public class Main {
    static int N, M, count;
    static List<List<Integer>> request;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        request = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            request.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int pre = -1;
            for (int j = 0; j < i; j++) {
                int n = Integer.parseInt(st.nextToken())-1;
                if(pre != -1){
                    if (!request.get(n).contains(pre)) request.get(n).add(pre);
                }
                pre = n;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if(request.get(i).isEmpty()) {
                que.offer(i);
                sb.append(i+1).append("\n");
                count++;
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < request.size(); i++) {
                List<Integer> r = request.get(i);
                if(r.contains(cur)){
                    r.remove(r.indexOf(cur));
                    if (r.size() == 0) {
                        que.add(i);
                        sb.append(i+1).append("\n");
                        count++;
                    }
                }
            }
        }

        if(count == N)
            System.out.println(sb);
        else System.out.println(0);
    }

}