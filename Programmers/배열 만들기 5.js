import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(String intStr : intStrs) {
            int subStr = Integer.parseInt(intStr.substring(s, s + l));
            if(k < subStr) {
                ans.add(subStr);
            }
        }
        
        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}