import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int idx = 0; idx < arr.length; idx++) {
            while (!ans.isEmpty() && (ans.getLast() >= arr[idx])) {
                ans.removeLast();
            }

            ans.add(arr[idx]);
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}