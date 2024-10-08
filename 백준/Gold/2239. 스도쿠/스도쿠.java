import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	static boolean[][] sector, row, col;
	static ArrayList<int[]> empty;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		board = new int[9][9];
		sector = new boolean[9][10];
		row = new boolean[9][10];
		col = new boolean[9][10];
		empty = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String line = br.readLine();
			for(int j=0;j<9;j++) {
				board[i][j] = line.charAt(j)-'0';
				
				if(board[i][j]==0) {
					empty.add(new int[] {i,j});
					continue;
				}
				
				row[i][board[i][j]]=true;
				col[j][board[i][j]]=true;
				if(i<3) {
					if(j<3) sector[0][board[i][j]]=true;
					else if(j<6) sector[1][board[i][j]]=true;
					else sector[2][board[i][j]]=true;
				}else if (i<6) {
					if(j<3) sector[3][board[i][j]]=true;
					else if(j<6) sector[4][board[i][j]]=true;
					else sector[5][board[i][j]]=true;
				}else {
					if(j<3) sector[6][board[i][j]]=true;
					else if(j<6) sector[7][board[i][j]]=true;
					else sector[8][board[i][j]]=true;
					
				}
			}
		}
		
		trial(0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	private static boolean trial(int idx) {
		if(idx==empty.size()) return true;
		
		int[] cur = empty.get(idx);
		int cs = 0;
		
		if(cur[0]<3) {
			if(cur[1]<3) cs = 0;
			else if(cur[1]<6) cs = 1;
			else cs = 2;
		}else if (cur[0]<6) {
			if(cur[1]<3) cs = 3;
			else if(cur[1]<6) cs = 4;
			else cs = 5;
		}else {
			if(cur[1]<3) cs = 6;
			else if(cur[1]<6) cs = 7;
			else cs = 8;
		}
		
		for(int i=1; i<=9; i++) {
			if(!sector[cs][i] && !row[cur[0]][i] && !col[cur[1]][i]) {
				sector[cs][i] = true;
				row[cur[0]][i] = true;
				col[cur[1]][i] = true;
				board[cur[0]][cur[1]] = i;
				if(trial(idx+1)) return true;
				sector[cs][i] = false;
				row[cur[0]][i] = false;
				col[cur[1]][i] = false;
			}
		}
		return false;
	}
}