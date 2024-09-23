import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int s, e, M = Integer.parseInt(br.readLine());
		boolean pd;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			s = Integer.parseInt(st.nextToken())-1;
			e = Integer.parseInt(st.nextToken())-1;
			pd = true;
			while (s<=e&&pd) {
				if(arr[s]!=arr[e]) pd=false;
				s++;
				e--;
			}
			
			if(pd) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
	}
}