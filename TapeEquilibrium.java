import static java.lang.Math.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int N = A.length;
        long sum = 0L;
        for(int i=0; i < N; ++i) {
            sum += A[i];
        }
        
        long diff = Long.MAX_VALUE;
        
        long[] p = new long[N];
        p[0] = 0L;
        for(int i=1; i < N; ++i) {
            p[i] = p[i-1] + A[i-1];
            
            //System.out.println(p[i]);
            
            diff = min(diff, abs(2*p[i] - sum));
        }
        
        return (int)diff;
    }
}
