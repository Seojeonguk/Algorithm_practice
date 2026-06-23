class Solution {
    public int[] solution(int[] arr, int n) {
        int length = arr.length;

        for (int idx = (length % 2 == 0 ? 1 : 0); idx < length; idx += 2) {
            arr[idx] += n;
        }

        return arr;
    }
}