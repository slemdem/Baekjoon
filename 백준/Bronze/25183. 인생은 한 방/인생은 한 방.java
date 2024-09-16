import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=1, N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char cur, pre =' ';
		boolean sucess = false;

		for(int i=0; i<N; i++){
			cur = str.charAt(i);
			if(cur == (char)(pre+1) || cur == (char)(pre-1)){
				cnt++;
				if (cnt==5){
					sucess = true;
					break;
				}
			}else cnt = 1;
			pre = cur;
		}
		
		if(sucess)System.out.println("YES");
		else System.out.println("NO");
	}
}