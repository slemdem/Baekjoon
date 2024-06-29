import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {
     public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        String S,E;
		StringBuilder sb;
        for(int test_case = 1; test_case <= T; test_case++)
		{
            S = sc.next();
            E = sc.next();

            for (int i=E.length()-1; i>=S.length();i--) {
                if(E.charAt(i)=='X'){
                    E= E.substring(0,i);
                }else{
                    sb = new StringBuilder(E.substring(0,i));
                    E= sb.reverse().toString();
                }
            }

            if (E.equals(S)){
                System.out.printf("#%d Yes\n",test_case);
            } else {
                System.out.printf("#%d No\n",test_case);
            }
        }
	}
}