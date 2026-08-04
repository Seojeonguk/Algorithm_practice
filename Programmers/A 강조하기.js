class Solution {
    public String solution(String myString) {
        String ans = "";

        char[] chars = myString.toCharArray();
        for (char c : chars) {
            if(c == 'a' || c == 'A') {
                ans = ans + Character.toUpperCase(c);
            } else {
                ans = ans + Character.toLowerCase(c);
            }
        }
        
        return ans;
    }
}