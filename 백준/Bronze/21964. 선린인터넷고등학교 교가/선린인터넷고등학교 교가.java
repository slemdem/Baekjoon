import java.io.*;

public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		String str = br.readLine();
		

		System.out.println(str.substring( str.length()-5));
	}
}