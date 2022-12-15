class Solution {
    public static int solution(String s) {
        int answer=0;
        char x=0;
        int xCnt=0, notXCnt=0;
        for(int idx=0;idx<s.length();idx++) {
            if(xCnt==notXCnt) {
                answer++;
                x = s.charAt(idx);
            }
            if(x==s.charAt(idx)) {
                xCnt++;
            } else {
                notXCnt++;
            }
        }

        return answer;
    }
}