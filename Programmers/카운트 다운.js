import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.iterate(start_num, i -> i - 1)
                .limit(start_num - end_num + 1)
                .toArray();
    }
}