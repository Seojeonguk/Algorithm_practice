import java.util.ArrayList;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> splits = new ArrayList<>();

        int length = my_str.length();
        for (int idx = 0; idx < length; idx += n) {
            splits.add(my_str.substring(idx, Math.min(idx + n, length)));
        }

        return splits.toArray(new String[0]);
    }
}