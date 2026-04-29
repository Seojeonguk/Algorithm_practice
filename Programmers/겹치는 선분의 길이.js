class Solution {
    public int solution(int[][] lines) {
        int[] count = new int[201];

        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];

            for (int i = start; i < end; i++) {
                count[i + 100]++;
            }
        }

        int answer = 0;

        for (int c : count) {
            if (c >= 2) {
                answer++;
            }
        }

        return answer;
    }
}