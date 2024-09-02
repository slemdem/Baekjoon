import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int a = Integer.parseInt(str.substring(0, str.length()/2));
		int b = Integer.parseInt(str.substring(str.length()/2));
		
		System.out.println(a+" "+b);
	}
}