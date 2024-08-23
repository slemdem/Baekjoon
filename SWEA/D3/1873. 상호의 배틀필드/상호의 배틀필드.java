import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	static char[][] feild;
	static int T, H, W;
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; ++testcase){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			feild = new char[H][W];
			String str;
			int tankx=0,tanky=0,head=0;
			for(int i=0; i<H;i++) {
				str = br.readLine();
				for (int j=0; j<W;j++) {
					feild[i][j] = str.charAt(j);
					if(feild[i][j]=='^') {
						tankx=i;
						tanky=j;
						head=0;
					}else if(feild[i][j]=='>') {
						tankx=i;
						tanky=j;
						head=1;
					}else if(feild[i][j]=='v') {
						tankx=i;
						tanky=j;
						head=2;
					}else if(feild[i][j]=='<') {
						tankx=i;
						tanky=j;
						head=3;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			int[] newxy;
			str = br.readLine();
			for(int i=0; i<N;i++) {
				switch (str.charAt(i)) {
				case 'S':
					shot(tankx,tanky,head);
					break;
				case 'U':
					head = 0;
					newxy = move(tankx,tanky,head);
					tankx = newxy[0];
					tanky = newxy[1];
					break;
				case 'R':
					head = 1;
					newxy = move(tankx,tanky,head);
					tankx = newxy[0];
					tanky = newxy[1];
					break;
				case 'D':
					head = 2;
					newxy = move(tankx,tanky,head);
					tankx = newxy[0];
					tanky = newxy[1];
					break;
				case 'L':
					head = 3;
					newxy = move(tankx,tanky,head);
					tankx = newxy[0];
					tanky = newxy[1];
					break;
				}
			}
			sb.append("#"+testcase+" ");
			for(char[] l : feild) {
				sb.append(String.copyValueOf(l)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void shot(int x, int y, int head) {
		int dx=0,dy=0;
		switch(head) {
		case 0:
			dx=-1;
			break;
		case 1:
			dy=1;
			break;
		case 2:
			dx=1;
			break;
		case 3:
			dy=-1;
			break;
		}
		while(x+dx<H && x+dx>=0 && y+dy<W && y+dy>=0) {
			if(feild[x+dx][y+dy]=='#') return;
			if(feild[x+dx][y+dy]=='*') {
				feild[x+dx][y+dy] = '.';
				return;
			}
			x+=dx;
			y+=dy;
		}
	}
	
	static int[] move(int x, int y, int head) {
		feild[x][y]='.';
		
		int dx=0,dy=0;
		switch(head) {
		case 0:
			dx=-1;
			break;
		case 1:
			dy=1;
			break;
		case 2:
			dx=1;
			break;
		case 3:
			dy=-1;
			break;
		}
		
		if (x+dx<H && x+dx>=0 && y+dy<W && y+dy>=0 && feild[x+dx][y+dy]=='.') {
			x+=dx;
			y+=dy;
		}
		feild[x][y]=headfor(head);
		return new int[] {x,y};
	}

	static char headfor(int head) {
		switch(head) {
			case 0:
				return '^';
			case 1:
				return '>';
			case 2:
				return 'v';
			case 3:
				return '<';
		}
		return '.';
	}
}