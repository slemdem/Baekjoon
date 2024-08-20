import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int min = Math.min(N, M);
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<Integer>[] ad = new ArrayDeque[min/2];
		
		for(int i=0; i<min/2; i++) {
			ad[i] = new ArrayDeque<Integer>();
			
			for(int j=i;j<M-i;j++)
				ad[i].add(arr[i][j]);
			for(int j=i+1;j<N-i;j++)
				ad[i].add(arr[j][M-i-1]);
			for(int j=M-i-2;j>=i;j--)
				ad[i].add(arr[N-i-1][j]);
			for(int j=N-i-2;j>=i+1;j--)
				ad[i].add(arr[j][i]);
//			System.out.println(Arrays.deepToString(ad[i].toArray()));
		}
		
		for(int i=0; i<R;i++) {
			for(ArrayDeque<Integer> a: ad)
				a.add(a.poll());
		}
		
		for(int i=0; i<min/2; i++) {
			for(int j=i;j<M-i;j++)
				arr[i][j] = ad[i].poll();
			for(int j=i+1;j<N-i;j++)
				arr[j][M-i-1] = ad[i].poll();
			for(int j=M-i-2;j>=i;j--)
				arr[N-i-1][j] = ad[i].poll();
			for(int j=N-i-2;j>=i+1;j--)
				arr[j][i] = ad[i].poll();
		}
		
		for(int[]a : arr) {
			for(int i=0; i<a.length;i++) {
				sb.append(a[i]);
				if (i==a.length-1) 
					sb.append("\n");
				else
					sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}