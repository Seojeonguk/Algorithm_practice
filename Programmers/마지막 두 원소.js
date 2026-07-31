class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length + 1];
        for (int i = 0; i < num_list.length; i++) {
            result[i] = num_list[i];
        }

        int lastSecond = num_list[num_list.length - 2];
        int last = num_list[num_list.length - 1];
        result[num_list.length] = (lastSecond < last ? last - lastSecond : last * 2);

        return result;
    }
}