class Solution {
    public String solution(String my_string, int m, int c) {
        String ans = "";
        int length = my_string.length();
        for (int idx = c - 1; idx < length; idx += m) {
            ans = ans.concat(String.valueOf(my_string.charAt(idx)));
        }

        return ans;
    }
}