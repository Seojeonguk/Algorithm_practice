import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> indicesSet = Arrays.stream(indices).boxed().collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();

        char[] chars = my_string.toCharArray();
        for (int idx = 0; idx < chars.length; idx++) {
            if (indicesSet.contains(idx)) {
                continue;
            }

            sb.append(chars[idx]);
        }

        return sb.toString();
    }
}