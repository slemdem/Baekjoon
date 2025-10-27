import java.io.*;
import java.util.*;

public class Main {
    static int N, Full, INF = Integer.MAX_VALUE;
    static char[] dirct = {'l','r','u','d'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < dirct.length; i++) 
            result = Math.max(result, move(1, dirct[i], deepCopy(B)));
        
        System.out.println(result);
    }

    public static int[][] deepCopy(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i] = arr[i].clone();
        }
        return result;
    }

    public static int move(int count, char d, int[][] board){
        Deque<Integer> stack = new LinkedList<>();
        boolean joined = false;

        switch (d) {
            case 'l':
                for (int i = 0; i < board.length; i++) {
                    joined = false;

                    for (int j = 0; j < board.length; j++) {
                        if (board[i][j] == 0) continue;
                        
                        if(!stack.isEmpty() && stack.peekLast() == board[i][j] && !joined) {
                            stack.add(stack.pollLast()+board[i][j]);
                            joined = true;
                        }
                        else{
                            stack.add(board[i][j]);
                            joined = false;
                        }
                    }

                    for (int j = 0; j < board.length; j++) {
                        if(!stack.isEmpty())
                            board[i][j] = stack.pollFirst();
                        else board[i][j] = 0;
                    }
                }
                
                break;

            case 'r':
                for (int i = 0; i < board.length; i++) {
                    joined = false;

                    for (int j = board.length-1; j >= 0 ; j--) {
                        if (board[i][j] == 0) continue;

                        if(!stack.isEmpty() && stack.peekLast() == board[i][j] && !joined) {
                            stack.add(stack.pollLast()+board[i][j]);
                            joined = true;
                        }
                        else {
                            stack.add(board[i][j]);
                            joined = false;
                        }
                    }

                    for (int j = board.length-1; j >= 0 ; j--) {
                        if(!stack.isEmpty())
                            board[i][j] = stack.pollFirst();
                        else board[i][j] = 0;
                    }
                }
                break;
        
            case 'u':
                for (int i = 0; i < board.length; i++) {
                    joined = false;

                    for (int j = 0; j < board.length; j++) {
                        if (board[j][i] == 0) continue;
                        
                        if(!stack.isEmpty() && stack.peekLast() == board[j][i] && !joined) {
                            stack.add(stack.pollLast()+board[j][i]);
                            joined = true;
                        }
                        else {
                            stack.add(board[j][i]);
                            joined = false;
                        }
                    }

                    for (int j = 0; j < board.length; j++) {
                        if(!stack.isEmpty())
                            board[j][i] = stack.pollFirst();
                        else board[j][i] = 0;
                    }
                }
                
                break;
        
            case 'd':
                for (int i = 0; i < board.length; i++) {
                    joined = false;

                    for (int j = board.length-1; j >= 0 ; j--) {
                        if (board[j][i] == 0) continue;
                        
                        if(!stack.isEmpty() && stack.peekLast() == board[j][i] && !joined) {
                            stack.add(stack.pollLast()+board[j][i]);
                            joined = true;
                        }
                        else {
                            stack.add(board[j][i]);
                            joined = false;
                        }
                    }

                    for (int j = board.length-1; j >= 0 ; j--) {
                        if(!stack.isEmpty())
                            board[j][i] = stack.pollFirst();
                        else board[j][i] = 0;
                    }
                }
                
                break;
        
            default:
                break;
        }

        int result = 0;

        //System.out.println(count);
        //for(int i =0; i<N; i++)
        //    System.out.println(Arrays.toString(board[i]));

        if (count==5){
            for(int i = 0; i<board.length; i++) {
                for(int j = 0; j<board.length; j++) {
                    result = Math.max(result, board[i][j]);
                }
            }
        } else {
            for (int i = 0; i < dirct.length; i++) 
                result = Math.max(result, move(count+1, dirct[i], deepCopy(board)));
        }
        return result;
    }
}