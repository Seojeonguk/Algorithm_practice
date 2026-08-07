class Solution {
    public String solution(String my_string, int s, int e) {
        return new StringBuilder(my_string.substring(s, e + 1))
                .reverse()
                .insert(0, my_string.substring(0, s))
                .append(my_string.substring(e + 1))
                .toString();
    }
}