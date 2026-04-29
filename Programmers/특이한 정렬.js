import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist)
                .boxed()
                .sorted((a, b) -> {
                    int diff = Math.abs(a - n) - Math.abs(b - n);
                    if (diff == 0) {
                        return b - a;
                    }
                    return diff;
                })
                .mapToInt(i -> i)
                .toArray();
    }
}