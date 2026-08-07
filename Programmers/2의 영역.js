class Solution {
    public int[] solution(int[] arr) {
        int firstIdx = -1;
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == 2) {
                firstIdx = idx;
                break;
            }
        }

        int lastIdx = -1;
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            if (arr[idx] == 2) {
                lastIdx = idx;
                break;
            }
        }

        if (firstIdx == -1 && lastIdx == -1) {
            return new int[]{-1};
        }

        int[] ans = new int[lastIdx - firstIdx + 1];
        System.arraycopy(arr, firstIdx, ans, 0, ans.length);

        return ans;
    }
}