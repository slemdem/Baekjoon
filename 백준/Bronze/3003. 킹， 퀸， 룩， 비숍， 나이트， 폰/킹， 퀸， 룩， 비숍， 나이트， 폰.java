import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str =br.readLine().split(" ");
        int[] curvalues= Stream.of(str).mapToInt(Integer::parseInt).toArray();
        int[] rightvalues = {1,1,2,2,2,8};
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<rightvalues.length;i++){
            sb.append((rightvalues[i] - curvalues[i])+" ");
        }
        System.out.printf(sb.toString());
    }
}