import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int M;
        
        for (int i = 1; i<=N; i++) {
            M = Integer.parseInt(br.readLine());
            Map<String, List<String>> clothes = new HashMap<>();
            for (int j = 0; j<M; j++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	String value = st.nextToken();
            	String key = st.nextToken();
            	
            	if (clothes.get(key)!= null) {
            		clothes.get(key).add(value);
            	}else {
            		LinkedList<String> l = new LinkedList<>();
            		l.add(value);
            		clothes.put(key, l);
            	}
            }
            Set<String> keys = clothes.keySet();
            int[] counts = new int[clothes.size()];
            int cp = 0;
            for(String k : keys) {
            	counts[cp] = clothes.get(k).size()+1;
            	cp++;
            }
            
            int sums = 1;
        	for(int j=0; j<cp; j++) {
            	sums*=counts[j];
            }
        	sb.append(sums-1).append("\n");
        }
        
        System.out.println(sb);
    }

}