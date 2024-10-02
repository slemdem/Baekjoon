import java.util.*;
import java.io.*;

public class Solution {
	static int K;
    static ArrayList<Integer>[] gear;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
            K = Integer.parseInt(br.readLine());
            
            gear = new ArrayList[4];
            for(int n=0; n<4;n++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	gear[n] = new ArrayList<>();
	            for (int i=0; i<8;i++) {
	            	gear[n].add(Integer.parseInt(st.nextToken()));
	            }
            }
            
            for(int i=0; i<K; i++) {
            	st = new StringTokenizer(br.readLine(), " ");
            	int start = Integer.parseInt(st.nextToken())-1;
            	int dir = Integer.parseInt(st.nextToken());
            	
            	rotate(start, start, dir);
            }

            int ans=0;
            for (int i=0; i<4;i++) {
            	if(gear[i].get(0)==1) ans+=Math.pow(2, i);
            }
            
            
			sb.append("#"+test+" "+ans+"\n");
		}
		System.out.println(sb);
	}
    
    
	private static void rotate(int cur, int from, int dir) {
		if(cur == from) {
			if(cur+1<4 && gear[cur].get(2)!=gear[cur+1].get(6)) {
				rotate(cur+1, cur, dir*-1);
			}
			
			if(cur-1>=0 && gear[cur].get(6)!=gear[cur-1].get(2)) {
				rotate(cur-1, cur, dir*-1);
			}
			
			
			if(dir==-1) {
				gear[cur].add(gear[cur].get(0));
				gear[cur].remove(0);
			}else {
				gear[cur].add(0,gear[cur].get(7));
				gear[cur].remove(8);
			}
		}else {
			if(cur+1<4 && cur+1!=from && gear[cur].get(2)!=gear[cur+1].get(6)) {
				rotate(cur+1, cur, dir*-1);
			}
			
			if(cur-1>=0 && cur-1!=from && gear[cur].get(6)!=gear[cur-1].get(2)) {
				rotate(cur-1, cur, dir*-1);
			}
			
			if(dir==-1) {
				gear[cur].add(gear[cur].get(0));
				gear[cur].remove(0);
			}else {
				gear[cur].add(0,gear[cur].get(7));
				gear[cur].remove(8);
			}
		}
	}
}