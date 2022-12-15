class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long y = 1L*d/k*k;
        for(long x=0;x<=1L*d;x+=k) {
            while(x*x + y*y > 1L*d*d) {
                y-=k;
            }
            answer+=(y/k)+1;
        }
        return answer;
    }
}