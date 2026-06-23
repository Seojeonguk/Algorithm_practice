import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> copiedArr = new ArrayList<>();
        
        for(int idx=0;idx<arr.length;idx++) {
            int val = arr[idx];

            for (int rec = 0; rec < val; rec++) {
                copiedArr.add(val);
            }
        }

        return copiedArr.stream().mapToInt(i -> i).toArray();
    }
}