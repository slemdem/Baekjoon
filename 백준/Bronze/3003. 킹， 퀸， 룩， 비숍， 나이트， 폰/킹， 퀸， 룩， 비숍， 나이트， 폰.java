import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str =br.readLine().split(" ");
        int[] rightvalues = {1,1,2,2,2,8};
        int[] curvalues= Stream.of(str).mapToInt(Integer::parseInt).toArray();
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<rightvalues.length;i++){
            rightvalues[i] = rightvalues[i] - curvalues[i];
            sb.append(rightvalues[i]+" ");
        }
        System.out.printf(sb.toString());
    }
    
}