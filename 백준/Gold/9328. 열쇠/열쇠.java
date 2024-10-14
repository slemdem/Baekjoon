import java.util.*;
import java.io.*;

public class Main {
	static int H, W, dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};
	static char[][] arr;
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
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            String str;
            
            arr = new char[H][W];
            boolean[][] visited= new boolean[H][W];
            enter = new ArrayList<>();
            Set<Character> keys = new HashSet<>();
            int result = 0;
            
            for(int i=0; i<H;i++) {
            	str = br.readLine();
                for(int j=0; j<W;j++) {
                	arr[i][j] = str.charAt(j);
                	if((i==0||i==H-1||j==0||j==W-1)&& arr[i][j]!='*') {
                		if(arr[i][j]=='$') result++;
            			if(arr[i][j]>='a'&&arr[i][j]<='z') keys.add(arr[i][j]);
                		enter.add(new int[] {i,j});
                		visited[i][j] = true;
                	}
                }
            }

        	str = br.readLine();
            
            for(int i=0; i<str.length(); i++) {
            	keys.add(str.charAt(i));
            }

            Deque<int[]> deque = new LinkedList<>();

            for(int[] d:enter) deque.add(d);
            int cnt=0;
            boolean changed = true;
            while(!deque.isEmpty() && cnt<=1) {
//            	System.out.println(Arrays.toString(keys.toArray()));
            	changed = false;
            	for(int d=0; d<deque.size();d++) {
	            	int[] cur = deque.poll();
	            	
	            	// 잠겨있고 못열 경우
	            	if(arr[cur[0]][cur[1]]>='A'&&arr[cur[0]][cur[1]]<='Z'&&!keys.contains((char)(arr[cur[0]][cur[1]]+32))) {
	            		deque.add(cur);
	            		continue;
	            	}

	            	// 탐색
	            	for(int i=0; i<4; i++) {
	            		int cx = cur[0]+dx[i];
	            		int cy = cur[1]+dy[i];
	            		if(cx<H&&cx>=0&&cy<W&&cy>=0&&arr[cx][cy]!='*'&&!visited[cx][cy]) {
	            			// 키 획득
	            			if(arr[cx][cy]>='a'&&arr[cx][cy]<='z') keys.add(arr[cx][cy]);
	            			// 문서 획득
	            			if(arr[cx][cy]=='$') result++;
	            			
	            			// 다음 노드
	            			visited[cx][cy] = true;
	            			deque.add(new int[] {cx,cy});
	            			changed = true;
	                    	cnt = 0;
	            		}
	            	}
	            	
            	}
            	if(!changed) cnt++;
            }
            
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
    
}
