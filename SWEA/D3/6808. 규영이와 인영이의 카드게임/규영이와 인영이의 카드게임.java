import java.util.*;
import java.io.*;

class Solution
{
	static int[] p1;
	static int[] p2;
	static boolean[] p2card;
	static int win, lose;
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			p2card = new boolean[19];
			p1 = new int[9];
			for(int i= 0; i<9;i++) {
				p1[i] = Integer.parseInt(st.nextToken());
				p2card[p1[i]]=true;
			}

			p2 = new int[9];
			int ptr = 0;
			for(int i = 1; i<=18; i++) {
				if (!p2card[i])
					p2[ptr++] = i;
			}
			
			p2card = new boolean[9];
			int[] p2cordi = new int[9];
			
			for (int i = 0; i<9; i++) {
				p2card[i] = true;
				p2cordi[0] = p2[i];
				coordi(p2cordi,1);
				p2card[i] = false;
			}
			
			sb.append("#"+test_case+" "+win+" "+lose+"\n");
		}
		System.out.println(sb);
	}

	private static void coordi(int[] p2cordi, int d ) {
		// TODO Auto-generated method stub
		if(d>=9) {
			int score = 0;
			for(int i=0; i<9;i++) {
				if (p1[i]>p2cordi[i]) {
					score += p1[i]+p2cordi[i];
				}
				else if (p1[i]<p2cordi[i]){
					score -= p1[i]+p2cordi[i];
				}
			}
			
			if(score>0) win+=1;
			else if (score<0) lose+=1;
			return;
		}
		
		for (int i = 0; i<9; i++) {
			if(p2card[i]) continue;
			
			p2card[i] = true;
			p2cordi[d] = p2[i];
			coordi(p2cordi,d+1);
			p2card[i] = false;
		}
	}
}