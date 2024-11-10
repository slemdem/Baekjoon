import java.io.*;
import java.util.*;

public class Main {
	static Deque<String> intque;
    static Deque<Character> calque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        
        intque = new LinkedList<>();
        calque = new LinkedList<>();
        
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            // 연산자와 피연산자 구분
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || cur == '(' || cur == ')') {
                handleOperator(cur);
            } else {
                intque.add(Character.toString(cur));
            }
        }
        
        // 남아있는 연산자를 intque에 추가
        while (!calque.isEmpty()) {
            intque.add(Character.toString(calque.pollLast()));
        }
        
        // 후위 표기법 변환 결과 출력
        while (!intque.isEmpty()) sb.append(intque.pollFirst());
        System.out.println(sb);
    }

	private static void handleOperator(char op) {
        if (op == '(') {
            calque.add(op);
        } else if (op == ')') {
            while (!calque.isEmpty() && calque.peekLast() != '(') {
                intque.add(Character.toString(calque.pollLast()));
            }
            if (!calque.isEmpty()) calque.pollLast(); // '(' 제거
        } else {
            // 연산자의 우선순위에 따라 처리
            while (!calque.isEmpty() && precedence(calque.peekLast()) >= precedence(op)) {
                intque.add(Character.toString(calque.pollLast()));
            }
            calque.add(op);
        }
    }

	private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}