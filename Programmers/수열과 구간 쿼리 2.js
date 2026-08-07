class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryAns = Integer.MAX_VALUE;

            for (int idx = queries[i][0]; idx <= queries[i][1]; idx++) {
                if (arr[idx] <= queries[i][2]) {
                    continue;
                }

                queryAns = Math.min(queryAns, arr[idx]);
            }

            answer[i] = queryAns == Integer.MAX_VALUE ? -1 : queryAns;
        }
        return answer;
    }
}