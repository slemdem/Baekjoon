import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {
    static int N, M;
    static int[] basket;
    static int[][] ijk;
    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        basket = new int[N];
        ijk = new int[M][3];
        for(int i=0; i<M;i++){
            String[] str =br.readLine().split(" ");
            ijk[i] = Stream.of(str).mapToInt(Integer::parseInt).toArray();
            for (int j=ijk[i][0]-1; j<ijk[i][1];j++){
                basket[j] = ijk[i][2];
            }

        }
        for(int i=0; i<N;i++){
            System.out.print(basket[i]+" ");
        }
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
    
}