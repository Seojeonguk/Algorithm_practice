class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] list = new int[end_num - start_num + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = start_num + i;
        }

        return list;
    }
}