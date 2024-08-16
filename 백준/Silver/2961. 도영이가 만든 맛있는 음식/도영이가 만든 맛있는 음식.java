import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[] bitter;
    static int[] souer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        souer = new int[N];
        bitter = new int[N];
        visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	souer[i] = Integer.parseInt(st.nextToken());
        	bitter[i] = Integer.parseInt(st.nextToken());
        }

        cook(0, 1, 0, 0);
        System.out.println(min);
    }

    public static void cook(int n, int s, int b, int cnt) {
        if (n>=N ) {
        	if (cnt>0)
        		min= Math.min(Math.abs(s-b), min);
        	return;
        }
        
        visited[n]= true;
        cook(n+1,s*souer[n],b+bitter[n], cnt+1);
        visited[n]= false;
        cook(n+1,s,b,cnt);
    }
}