import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int res = Arrays.stream(num_list).sum();
        if (num_list.length <= 10) {
            res = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        }

        return res;
    }
}