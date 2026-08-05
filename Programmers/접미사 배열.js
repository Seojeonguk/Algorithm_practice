import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> result = new ArrayList<>();
        int length = my_string.length();
        for (int idx = 0; idx < length; idx++) {
            result.add(my_string.substring(idx));
        }

        result.sort(Comparator.naturalOrder());

        return result.toArray(String[]::new);
    }
}