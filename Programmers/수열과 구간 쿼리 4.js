class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int idx = query[0]; idx <= query[1]; idx++) {
                if (idx % query[2] == 0) {
                    arr[idx]++;
                }
            }
        }
        
        return arr;
    }
}