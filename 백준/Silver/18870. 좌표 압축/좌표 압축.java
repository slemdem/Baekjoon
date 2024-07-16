import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine()," ");
    	int[] arr = new int[N];
    	int[] order = new int[N];
        for (int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	order[i] = arr[i];
        }
        
        Arrays.sort(order);
    	Set<Integer> hashset = new HashSet<>();
    	Map<Integer, Integer> map = new HashMap<>();
    	int count = 0;
    	for (int o : order) {
    		if (!map.containsKey(o))
    			map.put(o, count++);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int a : arr) {
    		sb.append(map.get(a)).append(" ");
    	}
    	System.out.println(sb);
    }
}