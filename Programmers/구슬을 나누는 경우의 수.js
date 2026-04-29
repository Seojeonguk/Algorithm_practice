class Solution {
    public int solution(int balls, int share) {
        int cnt = 1;

        int max = Math.max(share, balls - share);
        int min = balls - max;

        boolean[] isUsed = new boolean[min + 1];
        for (int i = balls; i > max; i--) {
            int mul = i;
            for (int j = min; j >= 2; j--) {
                if (!isUsed[j] && (mul % j == 0)) {
                    mul /= j;
                    isUsed[j] = true;
                }
            }
            cnt *= mul;
        }

        for (int i = 2; i <= min; i++) {
            if (!isUsed[i]) {
                cnt /= i;
            }
        }

        return cnt;
    }
}