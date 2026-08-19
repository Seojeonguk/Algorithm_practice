import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int h = 0;

        for (int i = citations.length - 1; i >= 0; i--) {
            int count = citations.length - i;

            if (citations[i] >= count) {
                h = count;
            } else {
                break;
            }
        }

        return h;
    }
}