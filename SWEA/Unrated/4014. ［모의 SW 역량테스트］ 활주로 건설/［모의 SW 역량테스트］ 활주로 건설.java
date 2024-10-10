import java.util.*;
import java.io.*;

public class Solution {
	static int N;
    public static void main(String[] args) throws Exception
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= T; test++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            
            int[][] arr = new int[N][N];
            for(int i=0; i<N;i++) {
            	st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<N;j++) {
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result = 0;
            for(int i=0; i<N; i++) {
            	boolean available = true;
            	int cnt=0, h=arr[i][0];
            	
            	for (int j=0; j<N; j++) {
            		if(h==arr[i][j]) {
            			cnt++;
            		}else {
            			if(h-arr[i][j]==1) {
            				if(cnt<0) {
                				available = false;
                				break;
                			}
            				h = arr[i][j];
            				cnt=-X+1;
            			} else if(h-arr[i][j]== -1) {
            				if(cnt<X) {
                				available = false;
                				break;
                			}
            				h = arr[i][j];
            				cnt=1;
            			}else {
            				available = false;
            				break;
            			}
            		}
            	}
            	
            	if(available&&cnt>=0) {
            		result++;
            	}
            }
            
            for(int i=0; i<N; i++) {
            	boolean available = true;
            	int cnt=0, h=arr[0][i];
            	for (int j=0; j<N; j++) {
            		if(h==arr[j][i]) {
            			cnt++;
            		}else {
            			if(h-arr[j][i]==1) {
            				if(cnt<0) {
                				available = false;
                				break;
                			}
            				h = arr[j][i];
            				cnt=-X+1;
            			} else if(h-arr[j][i]== -1) {
            				if(cnt<X) {
                				available = false;
                				break;
                			}
            				h = arr[j][i];
            				cnt=1;
            			}else {
            				available = false;
            				break;
            			}
            		}
            	}
            	
            	if(available&&cnt>=0) {
            		result++;
            	}
            }
            
			sb.append("#"+test+" "+result+"\n");
		}
		System.out.println(sb);
	}
	
}
