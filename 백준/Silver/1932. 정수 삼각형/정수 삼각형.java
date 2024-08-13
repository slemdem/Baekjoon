import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] nums;
    static int[] sums;
    static int ptr = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        nums = new int[N][];
        
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            nums[i] = new int[i+1];
        	for (int j = 0; j<=i; j++) {
	        	nums[i][j]=Integer.parseInt(st.nextToken());
	        	if(i!=0) {
	        		if(j==0) nums[i][j]+=nums[i-1][j];
	        		else if(j==i) nums[i][j]+=nums[i-1][j-1];
	        		else nums[i][j]+=Math.max(nums[i-1][j-1], nums[i-1][j]);
	        	}
        	}
        }
        
        int max = 0;
        for (int i:nums[N-1]) {
        	if (i>max) max=i;
        }
        
        System.out.println(max);
    }
}