class Solution {
    public String solution(String my_string, String alp) {
        return my_string.replaceAll(alp, String.valueOf(Character.toUpperCase(alp.charAt(0))));
    }
}