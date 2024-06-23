import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int[] numlist = new int[N];
        int count = 0;
        String[] str = br.readLine().split(" ");
        numlist = Stream.of(str).mapToInt(Integer::parseInt).toArray();
        int F = Integer.parseInt(br.readLine());
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] == F) count++;
        }

        System.out.println(count);
    }
    
}