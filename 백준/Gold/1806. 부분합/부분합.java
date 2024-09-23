import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine()," ");
		long[] arr = new long[N+1];
		for(int i=1;i<=N;i++) arr[i] = Long.parseLong(st.nextToken())+arr[i-1];

		int p = 0, result = Integer.MAX_VALUE;
		for (int i=1;i<=N;i++) {
			while(arr[i]-arr[p]>=S) {
				if(i-p<result) result = i-p;
				p++;
			}
		}
		
		if(result == Integer.MAX_VALUE) result = 0;
		System.out.println(result);
	}
}