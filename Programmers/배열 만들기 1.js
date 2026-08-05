import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int k) {
        return IntStream.iterate(k, i -> i + k)
                .limit(n / k)
                .filter(x -> x <= n)
                .toArray();
    }
}