import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        String word = st.nextToken();
        List<Character> chars = new ArrayList<>();
        int[] counts = new int[word.length()];
        char c;
        for(int i=0;i<word.length();i++){
            c = word.charAt(i);
            if('a'<=c && c<='z'){
                c = Character.toUpperCase(c);
            }
            if(chars.contains(c)){
                counts[chars.indexOf(c)] += 1;
            } else {
                chars.add(c);
                counts[chars.indexOf(c)]=1;
            }
        }
        int max = 0;
        char maxc = '?';
        for(int i=0; i<counts.length; i++){
            if(counts[i]<=0) break;

            if (counts[i]>max){
                max = counts[i];
                maxc = chars.get(i);
            }else if (counts[i] == max){
                maxc = '?';
            }
        }

        System.out.println(maxc);
    }
    
}