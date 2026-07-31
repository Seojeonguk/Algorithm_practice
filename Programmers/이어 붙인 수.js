class Solution {
    public int solution(int[] num_list) {
        String attachedOdd = "";
        String attachedEven = "";

        for (int x : num_list) {
            if (x % 2 == 0) {
                attachedEven = attachedEven + x;
            } else {
                attachedOdd = attachedOdd + x;
            }
        }

        return Integer.parseInt(attachedEven) + Integer.parseInt(attachedOdd);
    }
}