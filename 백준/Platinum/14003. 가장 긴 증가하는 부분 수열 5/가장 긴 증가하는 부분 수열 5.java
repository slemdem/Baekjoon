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
		ArrayList<int[]> elements = new ArrayList<>();
		for(int n=1; n<=N;n++) {
			int temp = Integer.parseInt(st.nextToken());
			if(LIS.isEmpty() || temp>LIS.get(LIS.size()-1)){
				elements.add(new int[] {LIS.size(),temp});
				LIS.add(temp);
			} else {
				int idx = function(temp);
				elements.add(new int[] {idx,temp});
				LIS.set(idx, temp);
			}
		}
		
		int idx = elements.size() - 1;
        int cur = LIS.size() - 1;
        
        for (int i = idx; i >= 0; i--) {
            int[] e = elements.get(i);
            if (e[0] == cur) {
                LIS.set(cur--, e[1]);
            }
        }
        
		sb.append(LIS.size()).append("\n");
        for(int i: LIS)sb.append(i).append(" ");
		System.out.println(sb);
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