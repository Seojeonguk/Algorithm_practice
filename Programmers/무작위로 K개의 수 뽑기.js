import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        arr = Arrays.stream(arr)
                .distinct()
                .toArray();

        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        System.arraycopy(arr, 0, answer, 0, Math.min(arr.length, k));

        return answer;
    }
}