class Solution {
    public int solution(int a, int b) {
        int oddCnt = (a % 2 == 1 ? 1 : 0) + (b % 2 == 1 ? 1 : 0);
        int answer = a * a + b * b;
        if (oddCnt == 1) {
            answer = 2 * (a + b);
        } else if (oddCnt == 0) {
            answer = Math.abs(a - b);
        }

        return answer;
    }
}