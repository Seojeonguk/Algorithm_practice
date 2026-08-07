import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int idx = 0; idx < flag.length; idx++) {
            if (flag[idx]) {
                for (int i = 0; i < arr[idx] * 2; i++) {
                    ans.add(arr[idx]);
                }
            } else {
                for (int i = 0; i < arr[idx]; i++) {
                    ans.removeLast();
                }
            }
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}