import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        int score = 0;
        if (arr[0] == arr[3]) {
            score = arr[0] * 1111;
        } else if (arr[0] == arr[2] || arr[1] == arr[3]) {
            score = 10 * arr[2] + (arr[0] == arr[2] ? arr[3] : arr[0]);
            score = score * score;
        } else if (arr[0] == arr[1] && arr[2] == arr[3]) {
            score = (arr[0] + arr[2]) * (arr[2] - arr[0]);
        } else if (arr[0] == arr[1]) {
            score = arr[2] * arr[3];
        } else if (arr[1] == arr[2]) {
            score = arr[0] * arr[3];
        } else if (arr[2] == arr[3]) {
            score = arr[0] * arr[1];
        } else {
            score = arr[0];
        }

        return score;
    }
}