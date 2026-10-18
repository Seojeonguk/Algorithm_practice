class Solution {
    public long solution(long n) {
        long sqrt = -1;
        for (int i = 1; (long) i * i <= n; i++) {
            if ((long) i * i == n) {
                sqrt = i;
            }
        }
        
        if(sqrt == -1) {
            return sqrt;
        }

        return (long) (sqrt + 1) * (sqrt + 1);
    }
}