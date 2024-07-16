import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long result = countOnesBetweenAAndB(A, B);
        System.out.println(result);
    }

    public static long countOnesInBinaryUpTo(long n) {
        long count = 0;
        long powerOfTwo = 1;

        while (powerOfTwo <= n) {
            long totalPairs = (n + 1) / (powerOfTwo * 2);
            long remainder = (n + 1) % (powerOfTwo * 2);

            count += totalPairs * powerOfTwo;
            count += Math.max(0, remainder - powerOfTwo);

            powerOfTwo *= 2;
        }

        return count;
    }

    public static long countOnesBetweenAAndB(long A, long B) {
        return countOnesInBinaryUpTo(B) - countOnesInBinaryUpTo(A - 1);
    }
}