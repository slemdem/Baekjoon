import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
	static int K;
	static int[][] film;
	static int[] blackLine;
	static int[] whiteLine;
	
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case=1; test_case<=T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int D = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
             
            film = new int[D][W];
            for(int i=0; i<D;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W;j++) {
                	film[i][j]=Integer.parseInt(st.nextToken());
                }
            }

        	if(isPass()) {
        		sb.append("#"+test_case+" 0\n");
        		continue;
        	}
        	
            blackLine = new int[W];
            for(int i=0; i<W;i++) blackLine[i]=1;
            whiteLine = new int[W];
            
            int[] changeLine = new int[D];
        	boolean pass = false;
            for(int i=0; i<D; i++) {
            	changeLine[D-1] = 1;
            	Arrays.sort(changeLine);
            	do {
            		if(changefilm(changeLine,0,0,i)) {
            			pass=true;
            			break;
            		}
            	}while(np(changeLine));
            	if(pass) break;
            }
            
            int cnt=0;
//            System.out.println(Arrays.toString(changeLine));
            for(int i : changeLine)
            	if (i==1) cnt++;
            
//            for(int[]a : film) System.out.println(Arrays.toString(a));
    		sb.append("#"+test_case+" "+(cnt-1)+"\n");
        }
        System.out.println(sb);
    }

	private static boolean changefilm(int[] changeLine, int start, int nowd, int depth) {
		if (nowd==depth) {
			return isPass();
		}
		boolean pass = false;
		for (int i=start; i<changeLine.length;i++) {
			if(changeLine[i]!=0) {
				int[] curLine = Arrays.copyOf(film[i], film[i].length);
				
				film[i]= blackLine;
				if(changefilm(changeLine, i+1, nowd+1, depth)) {
					pass = true;
					break;
				}
				
				film[i]= whiteLine;
				if(changefilm(changeLine, i+1, nowd+1, depth)) {
					pass = true;
					break;
				}
				
				film[i]=curLine;
			}
		}
		return pass;
	}

	private static boolean isPass() {
		boolean allpass = true;
		for (int i =0; i<film[0].length;i++) {
			boolean pass = false;
			int pre = 2;
			int cnt = 1;
			
			for (int j=0; j<film.length;j++) {
				int cur = film[j][i];
				
				if(pre == cur) cnt++;
				else {
					pre = cur;
					cnt=1;
				}
				
				if (cnt==K) {
					pass = true;
					break;
				}
			}
			
			if(!pass) {
				allpass=false;
				break;
			}
		}
//		if(allpass) {
//			for(int[] a: film) System.out.println(Arrays.toString(a));
//			System.out.println("======================");
//		}
		return allpass;
	}
	
	static boolean np(int[] p) {
		int N = p.length;
		
		//step1) 꼭대기 찾기
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		
		// step2 ) 꼭대기 앞 교환위치에 교환할 값 (i-1 위치의 값보다 큰 값중 가장 작은 값)
		if(i==0) return false;
		int j = N-1;
		while (p[i-1]>=p[j]) --j;
		
		//step3) 두 위치의 수 교환
		swap(p,i-1,j);
		
		//step4) 꼭대기 부터 맨 뒤까지 오름차순의 형태로 만듦
		int k = N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		return true;
	}
	
	static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i]=p[j];
		p[j]= temp;
	}
}