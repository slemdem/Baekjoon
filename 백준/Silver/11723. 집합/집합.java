import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        boolean[] ints = new boolean[20];
        int x=0;
        for (int tests = 0; tests<T; tests++) {
        	st = new StringTokenizer(br.readLine()," ");
        	String comand = st.nextToken();
        	if (st.countTokens()!=0){
        		x = Integer.parseInt(st.nextToken())-1;
        	}
        	
        	switch (comand) {
			case "add":
				ints[x] = true;
				break;
				
			case "remove":
				ints[x] = false;
				break;
				
			case "check":
				if(ints[x])
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
				
			case "toggle":
				ints[x] =!ints[x];
				break;
				
			case "all":
				for(int i=0; i<ints.length; i++) ints[i]=true;
				break;
				
			case "empty":
				ints = new boolean[20];
				break;
			default:
				break;
			}
        }
        System.out.println(sb);
    }
}