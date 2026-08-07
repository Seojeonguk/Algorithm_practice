import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int idx = 0; idx < arr.length; idx++) {
            if (ans.isEmpty()) {
                ans.add(arr[idx]);
            } else {
                if (ans.getLast() == arr[idx]) {
                    ans.removeLast();
                } else {
                    ans.add(arr[idx]);
                }
            }
        }

        if (ans.isEmpty()) {
            return new int[]{-1};
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}