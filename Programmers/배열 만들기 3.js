class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = new int[intervals[0][1] - intervals[0][0] + intervals[1][1] - intervals[1][0] + 2];

        for (int ansIdx = 0, idx = intervals[0][0]; idx <= intervals[0][1]; idx++, ansIdx++) {
            answer[ansIdx] = arr[idx];
        }

        for (int ansIdx = intervals[0][1] - intervals[0][0] + 1, idx = intervals[1][0]; idx <= intervals[1][1]; idx++, ansIdx++) {
            answer[ansIdx] = arr[idx];
        }

        return answer;
    }
}