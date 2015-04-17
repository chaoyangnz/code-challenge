// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int depth = -1;
        for(int i=1; i < n -1;) {
            int p = i - 1;
            int q = i;
            int r = i + 1;
            if(A[p] <= A[q] || A[r] <= A[q]) {
                i++;
               continue;
            }
           
            while(p > 0 && A[p-1] > A[p]) {
                p--;
            }
            while(r < n -1 && A[r+1] > A[r]) {
                r++;
            }
            i = r;
            // System.out.println("p: " + p);
            // System.out.println("q: " + q);
            // System.out.println("r: " + r);
            depth = Math.max(Math.min(A[p]-A[q], A[r]-A[q]), depth);
        }
        
        return depth;
    }
}
