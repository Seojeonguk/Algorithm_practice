import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int x = l; x <= r; x++) {
            if (isOnlyZeroOrFive(x)) {
                ans.add(x);
            }
        }
        
        if (ans.isEmpty()) {
            return new int[]{-1};
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    public boolean isOnlyZeroOrFive(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (char c : chars) {
            if (c != '0' && c != '5') {
                return false;
            }
        }

        return true;
    }
}