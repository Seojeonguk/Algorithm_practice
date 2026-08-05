import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n);

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            ans.add(n);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}