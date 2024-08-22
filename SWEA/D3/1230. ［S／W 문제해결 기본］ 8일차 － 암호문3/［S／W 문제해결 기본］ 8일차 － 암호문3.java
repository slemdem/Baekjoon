import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
         
        for(int test_case=1; test_case<=10; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	ArrayList<Integer> codes = new ArrayList<>();
        	
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N;i++) {
            	int s = Integer.parseInt(st.nextToken());
            	codes.add(s);
            }
            
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            String str;
            int x,y,s;
            for(int i=0; i<M;i++) {
            	str = st.nextToken();
                switch (str) {
				case "I":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						s = Integer.parseInt(st.nextToken());
						codes.add(x+j, s);
					}
					break;
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						codes.remove(x);
					}
					
					break;
				case "A":
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						s = Integer.parseInt(st.nextToken());
						codes.add(s);
					}
					
					break;
				}
            }

    		sb.append("#"+test_case+" ");
    		for(int i=0; i<9;i++)
    			sb.append(codes.get(i)+" ");
    		sb.append(codes.get(9)+"\n");
        }
        System.out.println(sb);
    }
}