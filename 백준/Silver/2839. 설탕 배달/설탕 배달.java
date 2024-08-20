import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = -1;
		
		for (int i=N/5;i>=0;i--) {
			if((N-(5*i))%3==0) {
				answer = i+(N-(5*i))/3;
				break;
			}
		}
		
		System.out.println(answer);
	}
}