class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int mod = 1; mod <= n; mod++) {
            if(n % mod == 0) {
                answer += mod;
            }
        }
        
        return answer;
    }
}