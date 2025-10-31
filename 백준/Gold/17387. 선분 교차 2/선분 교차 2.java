import java.io.*;
import java.util.*;

class point {
    long x, y;
    
    point(long x, long y){
        this.x = x;
        this.y = y;
    }
}


public class Main {
    static point A, B, C, D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        B = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        C = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        D = new point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        
        int v1 = ccw(A, B, C);
        int v2 = ccw(A, B, D);
        int v3 = ccw(C, D, A);
        int v4 = ccw(C, D, B);


        if(v1 * v2 <= 0 && v3 * v4 <= 0){
            if(v1 == 0 && v2 == 0){
                if (isOverlap(A, B, C, D))
                    System.out.println(1);
                else
                    System.out.println(0);
            } else 
                System.out.println(1);
        } else System.out.println(0);
    }

    public static int ccw(point a, point b, point c){
        long v = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

        if (v > 0) return 1;   // 반시계
        if (v < 0) return -1;  // 시계
        return 0;              // 일직선
    }

    public static boolean isOverlap (point a, point b, point c, point d) {
        return Math.max(Math.min(a.x, b.x), Math.min(c.x, d.x)) 
            <= Math.min(Math.max(a.x, b.x), Math.max(c.x, d.x))
            && Math.max(Math.min(a.y, b.y), Math.min(c.y, d.y)) 
            <= Math.min(Math.max(a.y, b.y), Math.max(c.y, d.y));
    }
}