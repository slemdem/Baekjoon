import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int sucess = 1;
			
			String str = br.readLine();
			LinkedList<Character> s = new LinkedList<>();
			
			for(int i = 0; i<N; i++) {
				if(str.charAt(i)=='{'||str.charAt(i)=='<'||str.charAt(i)=='['||str.charAt(i)=='(') 
					s.add(str.charAt(i));
				else {
					char c =' ';
					switch(str.charAt(i)) {
					case ')':c ='(';break;
					case '}':c ='{';break;
					case ']':c ='[';break;
					case '>':c ='<';break;
					}
					char o =s.pollLast();
					if(o!=c) {
						sucess=0;
						break;
					}
				}
			}
			
			sb.append("#"+test_case+" "+sucess+"\n");
		}
		System.out.println(sb);
	}

}