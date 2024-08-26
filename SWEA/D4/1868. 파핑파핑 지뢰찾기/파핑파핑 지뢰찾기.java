import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[][] arr;
	static int N;
    
    public static boolean dfs(int i, int j) {
        if (i>=0 && i<N && j>=0 && j<N && arr[i][j]==-2) {
        	return true;
        }
		boolean left,right,up,down;
		if(i>=0 && i<N && j>=0 && j<N && arr[i][j]!=-1) {
			if(arr[i][j]==0) {
                arr[i][j] = -1;
                up = dfs(i-1,j);
                down = dfs(i+1,j);
                left = dfs(i,j-1);
                right = dfs(i,j+1);
                dfs(i-1,j-1);
                dfs(i-1,j+1);
                dfs(i+1,j-1);
                dfs(i+1,j+1);
                return false;
			}else {
                arr[i][j]=-2;
                return true;
            }
		}
		return false;
	}
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int[N][N];
           
            for(int i=0; i<N; i++) {
            	String in = sc.next();
                for(int j=0; j<N; j++) {
                	if(in.charAt(j) == '*') {
                		arr[i][j] = -1;
                		if(i-1>=0) {
                			if (j-1>=0 && arr[i-1][j-1]!=-1) arr[i-1][j-1] +=1;
                			if (arr[i-1][j]!=-1) arr[i-1][j] +=1;
                			if (j+1<N && arr[i-1][j+1]!=-1) arr[i-1][j+1] +=1;
                		}
                		if (j-1>=0 && arr[i][j-1]!=-1) arr[i][j-1] +=1;
            			if (j+1<N && arr[i][j+1]!=-1) arr[i][j+1] +=1;
            			if(i+1<N) {
                			if (j-1>=0 && arr[i+1][j-1]!=-1) arr[i+1][j-1] +=1;
                			if (arr[i+1][j]!=-1) arr[i+1][j] +=1;
                			if (j+1<N && arr[i+1][j+1]!=-1) arr[i+1][j+1] +=1;
                		}
                	}
                }
            }
            
            int click = 0;
            for (int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                	if(arr[i][j]==0) {
                		dfs(i,j);
                		click++;
                	}
                }
            }
            
            for (int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                	if(arr[i][j]!=-1&&arr[i][j]!=-2) {
                		arr[i][j] = -1;
                		click++;
                	}
                }
            }
            System.out.printf("#%d %d\n",test_case,click);
		}
	}
}