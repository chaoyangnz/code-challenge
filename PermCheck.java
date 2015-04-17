// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int N = A.length;
        
        long expect_sum = N*(1+N)/2;
        long actual_sum = 0L;
        for(int i= 0; i < N; ++i) {
            actual_sum += A[i];
        }
        
        return (actual_sum == expect_sum) ? 1 : 0;
    }
}
