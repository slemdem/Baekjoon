import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int today, yesterday = 0, min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++){
			today = Integer.parseInt(st.nextToken());
			if(yesterday!=0 && yesterday*X+today*X<min)
					min = yesterday*X+today*X;
			yesterday = today;
		}
		
		System.out.println(min);
	}
}