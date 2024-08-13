import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static boolean[] flag;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        flag = new boolean[N+1];
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 1; i<=N; i++) {
        	nums[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        int[] arr = new int[M];
        for (int i = 1; i<=N; i++) {
        	flag[i] = true;
        	arr[0] = nums[i];
        	backtrack(arr, 1);
        	flag[i] = false;
        }
        
        
        System.out.println(sb);
    }
    public static void backtrack(int[] arr, int j) {
		if(j>=M) {
			arrtoSb(arr);
			return;
		}
// 	   System.out.println(i+" "+j);
		for (int k = 1;k<=N;k++) {
			if(flag[k]==true) continue;
			
			flag[k] = true;
	 		arr[j]=nums[k];
	 		backtrack(arr,j+1);
	 		flag[k] = false;
        }
	}
    
    public static void arrtoSb(int[] arr) {
		for(int i=0; i<arr.length;i++) {
			sb.append(arr[i]);
			if(i!=arr.length-1) sb.append(" ");
			else sb.append("\n");
		}
	}
}