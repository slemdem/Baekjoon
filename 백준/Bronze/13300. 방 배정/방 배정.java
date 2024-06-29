import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[6][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken())-1;
            arr[grade][gender]++;
        }

        int rooms=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<2;j++){
                if(arr[i][j]==0) continue;
                rooms += arr[i][j]/M;
                if(arr[i][j]%M>0){
                    rooms++;
                }
            }
        }
        System.out.print(rooms);
    }
}