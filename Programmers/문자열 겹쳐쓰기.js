class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] str = my_string.toCharArray();
        
        int length = overwrite_string.length();
        for(int i = 0, idx = s; i < length; i++, idx++) {
            char c = overwrite_string.charAt(i);
            str[idx] = c;
        }
        
        return String.valueOf(str);
    }
}