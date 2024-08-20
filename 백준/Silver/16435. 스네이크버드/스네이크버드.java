import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		int[] foods = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			foods[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(foods);
		int ptr = 0;
		while(ptr<N&&len>=foods[ptr]) {
			len++;
			ptr++;
		}
		System.out.println(len);
	}
}