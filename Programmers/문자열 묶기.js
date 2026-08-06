import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxAppearedLength = 0;
        for (String s : strArr) {
            int length = s.length();
            int appearedCnt = 1;
            if (map.containsKey(length)) {
                appearedCnt = map.get(length) + 1;
            }

            map.put(length, appearedCnt);
            maxAppearedLength = Math.max(maxAppearedLength, appearedCnt);
        }

        return maxAppearedLength;
    }
}