import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        String[] res = Arrays.stream(myStr.split("[abc]"))
                .filter(item -> !"".equals(item))
                .toArray(String[]::new);

        if (res.length == 0) {
            return new String[]{"EMPTY"};
        }

        return res;
    }
}