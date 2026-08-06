class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum = 0;
        for (int cur = a, idx = 0; idx < included.length; idx++, cur += d) {
            if (included[idx]) {
                sum += cur;
            }
        }

        return sum;
    }
}