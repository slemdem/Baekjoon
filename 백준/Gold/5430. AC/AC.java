import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){
        	String comand = br.readLine();
        	st = new StringTokenizer(br.readLine()," ");
        	
            int n = Integer.parseInt(st.nextToken());
            Deque<Integer> arr = new ArrayDeque<>();
            String arrs = br.readLine();
            arrs = arrs.substring(1, arrs.length()-1);

        	st = new StringTokenizer(arrs,",");
        	
        	for (int j =0; j<n; j++) {
        		arr.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	boolean error = false;
        	boolean head = true;
        	for (int j =0; j<comand.length(); j++) {
        		if(comand.charAt(j)=='R') {
        			head = !head;
        		}else {
        			if(arr.isEmpty()) {
        				error = true;
						break;
					}
    				if(head)arr.pollFirst();
    				else arr.pollLast();
        		}
        	}

            if (error) {
            	System.out.println("error");
            }else {
            	StringBuilder sbuild = new StringBuilder("[");
            	if(head) {
            		while (arr.size()>1) {
            			sbuild.append(arr.pollFirst());
            			sbuild.append(",");
            		}
            	}else {
            		while (arr.size()>1) {
            			sbuild.append(arr.pollLast());
            			sbuild.append(",");
            		}
            	}
            	if(!arr.isEmpty()) sbuild.append(arr.pollFirst());
    			sbuild.append("]");
    			System.out.println(sbuild);
            }
        }
    }
}