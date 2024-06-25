import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        int leng = str.length();
        
        Stack<Character> arr = new Stack<>();
        for(int i=0;i<leng/2;i++){
            arr.add(str.charAt(i));
        }
        
        int isPellindrom = 1;
        for(int i=(leng%2 == 1)?leng/2+1:leng/2; i<leng; i++){
            if(str.charAt(i)!=arr.pop()) isPellindrom = 0;
        }
        System.out.print(isPellindrom);
    }
}