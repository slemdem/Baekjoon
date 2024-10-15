import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, K, dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};
	static int[][] arr;
	static ArrayList<int[]> enter;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            arr = new int[N][M];
            HashSet<String> visited= new HashSet<>();
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2)-> o1[3]-o2[3]==0?o2[4]-o1[4]:o1[3]-o2[3]);
            
            for(int i=0; i<N;i++) {
            	st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M;j++) {
                	arr[i][j] = Integer.parseInt(st.nextToken());
                	if(arr[i][j]>0) {
	                	visited.add(i+","+j);
	                	que.add(new int[] {i, j, arr[i][j], 0, arr[i][j]});
                	}
                }
            }
            
            int cnt = 0;
			// System.out.println(que.size());

            while(!que.isEmpty() && cnt<K) {
            	int s =que.size();
//            	 System.out.println(cnt+" "+ s);
            	for(int q=0; q<s; q++) {
	            	int[] cur = que.poll();

	            	// 활성화되지 않음
	            	if(cur[2]>cur[3]) {
	            		que.add(new int[]{cur[0],cur[1],cur[2],cur[3]+1,cur[4]});
	            		continue;
	            	}

	            	// 이전에 활성화 됨
	            	if(cur[2]<cur[3]) {
	            		if(cur[2]+cur[4]-1>cnt) que.add(new int[]{cur[0],cur[1],cur[2],cur[3]+1,cur[4]});
	            		continue;
	            	}

//	            	 System.out.println(Arrays.toString(cur));
	            	// 탐색
	            	for(int i=0; i<4; i++) {
	            		int cx = cur[0]+dx[i];
	            		int cy = cur[1]+dy[i];
	            		if(!visited.contains(cx+","+cy)) {
							// System.out.println(cx+","+cy);
	            			visited.add(cx+","+cy);
	            			que.add(new int[] {cx,cy,cur[3]+cur[4]+1,cur[3]+1,cur[4]});
	            		}
	            	}
	            	
	            	if(cur[4]>1) que.add(new int[]{cur[0],cur[1],cur[2],cur[3]+1,cur[4]});;
            	}
            	cnt++;
        	}
			sb.append("#"+test+" "+que.size()+"\n");
		}
		System.out.println(sb);
	}
    
}
