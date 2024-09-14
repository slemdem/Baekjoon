import java.io.*;
import java.util.*;

public class Main {
	static Integer[] nums;
	static int N, M, l;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		nums = set.toArray(new Integer[1]);
		Arrays.sort(nums);
		l = nums.length;
		int[] results = new int[M];
		for (int i=0; i<l;i++) {
			results[0] = nums[i];
			function(results,i,1);
		}

		System.out.println(sb);
	}

	private static void function(int[] results, int k, int j) {
		if (j==M){
			for(int i =0; i<M; i++){
				sb.append(results[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=k; i<l;i++) {
			results[j] = nums[i];
			function(results,i,j+1);
		}
		return;
	}
}