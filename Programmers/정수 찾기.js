import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list)
                .filter(x -> x == n)
                .count() > 0 ? 1 : 0;
    }
}