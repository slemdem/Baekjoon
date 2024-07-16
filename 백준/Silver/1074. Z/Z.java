import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static int Z(int x, int y, int mid) {
		if (mid <= 1){
			switch (x) {
			case 0:
				switch (y) {
				case 0:
					return 0;
				default:
					return 1;
				}
			default:
				switch (y) {
				case 0:
					return 2;

				default:
					return 3;
				}
			}
		}
		int i;
		if (x-mid < 0 && y-mid >= 0) {
			i = Z(x,y-mid,mid/2)+(mid*mid);
		}else if (x-mid >= 0 && y-mid < 0) {
			i = Z(x-mid,y,mid/2)+(mid*mid)*2;
		}else if (x-mid >= 0 && y-mid >= 0) {
			i = Z(x-mid,y-mid,mid/2)+(mid*mid)*3;
		} else {
			i = Z(x,y,mid/2);
		}
		return i;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        System.out.println(Z(R,C,N/2));
    }
}