import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        boolean[] arr = new boolean[N+1];
        for (int i = 1; i<=N; i++) {
        	arr[i]=true;
    	   backtrack(arr,i+1,1);
    	   arr[i]=false;
        }
        System.out.println(sb);
    }
    public static void backtrack(boolean[] arr, int i, int j) {
		if(j>=M) {
			arrtoSb(arr);
			return;
		}
// 	   System.out.println(i+" "+j);
		for (int k = i;k<=N;k++) {
     	   arr[k]=true;
     	   backtrack(arr,k+1,j+1);
     	   arr[k]=false;
        }
	}
    
    public static void arrtoSb(boolean[] arr) {
		for(int i=0; i<arr.length;i++) {
			if (arr[i]) {
				sb.append(i);
				if(i!=arr.length) sb.append(" ");
			}
			if(i==arr.length-1) sb.append("\n");
		}
	}
}