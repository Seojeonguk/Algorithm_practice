class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        for (int num : numbers) {
            if (sum > n) {
                break;
            }

            sum += num;
        }

        return sum;
    }
}