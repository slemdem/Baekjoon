import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long result = -1;

		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[]{n,1});

		while (!q.isEmpty()) {
			long[] cur = q.poll();
			if(cur[0]==m){
				result = cur[1];
				break;
			}
			if(cur[0]*2<=m) q.offer(new long[]{cur[0]*2,cur[1]+1});
			if(cur[0]*10+1<=m) q.offer(new long[]{cur[0]*10+1,cur[1]+1});
		}
		
		System.out.println(result);
    }
}