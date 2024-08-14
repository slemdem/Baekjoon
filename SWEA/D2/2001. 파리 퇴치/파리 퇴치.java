import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			int hitrange = sc.nextInt()-1;
            int[][] arr = new int[N][N];
            int[][] hit = new int[N][N-hitrange];
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                	arr[i][j] = sc.nextInt();
                	if(j>=hitrange) {
                		for(int k=0; k<=hitrange; k++) {
                        	hit[i][j-hitrange] += arr[i][j-k];
                        }
                	}
                }
            }
            
            int max = 0;
            int sums;
            for(int i=0; i<N-hitrange; i++) {
                for(int j=0; j<N-hitrange; j++) {
                	sums = 0;
                	for(int k=0; k<=hitrange; k++) {
                		 sums += hit[i+k][j];
                    }
                	if(sums>max) max = sums;
                }
            }
            System.out.printf("#%d %d\n",test_case,max);
		}
	}
}