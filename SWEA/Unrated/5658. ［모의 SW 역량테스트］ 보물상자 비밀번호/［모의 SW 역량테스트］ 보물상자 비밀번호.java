import java.util.*;
import java.io.*;

public class Solution {
	static int N, K;
	static String S;
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
         
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	int n = N/4;
        	S = br.readLine();
        	
        	TreeSet<Integer> set = new TreeSet<>();
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<4; j++) {
		    		String str ="";
		    		if(j==3) {
		    			str = S.substring(n*j+i, N)+S.substring(0, i);
		    		}else str = S.substring(n*j+i, n*j+i+n);
		    		set.add(Integer.parseInt(str, 16));
        		}
        	}
        	for(int i=1;i<K;i++)
        		set.pollLast();
        	int ans = set.pollLast();
        	sb.append("#"+test+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
}
