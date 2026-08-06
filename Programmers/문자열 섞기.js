class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        int length = str1.length();
        for (int idx = 0; idx < length; idx++) {
            sb.append(str1.charAt(idx));
            sb.append(str2.charAt(idx));
        }

        return sb.toString();
    }
}