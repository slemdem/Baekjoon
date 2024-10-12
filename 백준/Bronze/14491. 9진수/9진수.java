import java.io.*;
import java.util.*;

public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int d = Integer.parseInt(br.readLine());
		Deque<Integer> que = new LinkedList<>();
		while (d>1) {
			que.addFirst(d%9);
			d/=9;
		}
		if(d>0)que.addFirst(d);
		
		while (!que.isEmpty()) {
			sb.append(que.pollFirst());
		}

		System.out.println(sb);
	}
}