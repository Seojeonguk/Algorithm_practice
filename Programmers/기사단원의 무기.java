class Solution {
    public int solution(int number, int limit, int power) {
        
        int[] divisorCnts = new int[100001];
        for(int i=1;i<=100000;i++) {
            for(int j=i;j<=100000;j+=i)
                divisorCnts[j]++;
        }
        
        int answer=0;
        for(int i=1;i<=number;i++) {
            int divisorCnt = divisorCnts[i];
            answer += (divisorCnt > limit ? power : divisorCnt);
        }
        return answer;
    }
}