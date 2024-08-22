import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
    static int R, C, cnt;
    static int[][] dxdy= {{-1,1},{0,1},{1,1}};
    static char[][] village;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        village = new char[R+2][C+2]; 
        
        for(int i = 1; i<=R;i++) {
        	String str = br.readLine();
            for(int j = 1; j<=C;j++) {
	        	village[i][j] = str.charAt(j-1);
        	}
        }
        
    	cnt = 0;
        for(int i= 1; i<=R;i++) {
        	if(dfs(i,1)) cnt++;
        }
        System.out.println(cnt);
    }
	private static boolean dfs(int x, int y) {
		if (village[x][y]!='.') return false;
		
		if(y==C) {
			village[x][y]='x';
			return true;
		}
		
		boolean pass = false;
		for (int i=0; i<3; i++) {
			if(village[x+dxdy[i][0]][y+dxdy[i][1]]=='.'&&dfs(x+dxdy[i][0], y+dxdy[i][1])) {
				pass = true;
				village[x][y]='x';
				break;
			}else village[x][y]='x';
		}
		return pass;
	}
}