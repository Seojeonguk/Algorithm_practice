import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        if (n == 1) {
            answer = Arrays.stream(num_list, 0, slicer[1] + 1)
                    .toArray();
        } else if (n == 2) {
            answer = Arrays.stream(num_list, slicer[0], num_list.length)
                    .toArray();
        } else if (n == 3) {
            answer = Arrays.stream(num_list, slicer[0], slicer[1] + 1)
                    .toArray();
        } else if (n == 4) {
            answer = IntStream.iterate(slicer[0], i -> i <= slicer[1], i -> i + slicer[2])
                    .map(i -> num_list[i])
                    .toArray();
        }

        return answer;
    }
}