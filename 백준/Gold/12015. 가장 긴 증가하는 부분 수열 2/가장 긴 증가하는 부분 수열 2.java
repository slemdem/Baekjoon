import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> LIS = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		for(int n=1; n<=N;n++) {
			int temp = Integer.parseInt(st.nextToken());
			if(LIS.isEmpty() || temp>LIS.get(LIS.size()-1)){
				LIS.add(temp);
			} else {
				int idx = function(temp);
				LIS.set(idx, temp);
			}
		}
		// System.out.println(Arrays.toString(LIS.toArray()));
		System.out.println(LIS.size());
	}

	private static int function(int temp) {
		// TODO Auto-generated method stub
		int min = 0, max = LIS.size(), mid = (min+max)/2;

		while (min<max) {
			if(temp == LIS.get(mid)){
				return mid;
			} else if (temp > LIS.get(mid)){
				min = mid+1;
				mid = (min+max)/2;
			} else {
				max = mid;
				mid = (min+max)/2;
			}
		}
		return mid;
	}
}