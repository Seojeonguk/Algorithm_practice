class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] chars = my_string.toCharArray();

        char[] result = new char[index_list.length];
        for (int i = 0; i < index_list.length; i++) {
            result[i] = chars[index_list[i]];
        }

        return String.valueOf(result);
    }
}