// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");
import static java.lang.Math.*;
import java.util.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        
        int[] p = new int[N+1]; // prefix sums of array
        p[0] = 0;
        for(int i = 0; i < N; ++i) {
            p[i+1] = p[i] + A[i];
        }
        
        Arrays.sort(p);
        
        int min_abs_sum = abs(A[0]);
        for(int i = 0; i < N; ++i) {
            if(abs(p[i+1]-p[i]) < min_abs_sum) {
                min_abs_sum = abs(p[i+1]-p[i]); // minimum difference between neighbor elements in sorted prefix sums array
            }
        }
        
        return min_abs_sum;
    }
}
