import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
	
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++){
			String str = br.readLine();
			if(str.length()<=9&&str.length()>=6){
				sb.append("yes\n");
			}else sb.append("no\n");
		}
		
		System.out.println(sb);
	}
}