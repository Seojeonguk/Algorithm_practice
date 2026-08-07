class Solution {
    public String solution(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();

        int length = code.length();
        for (int idx = r; idx < length; idx += q) {
            sb.append(code.charAt(idx));
        }

        return sb.toString();
    }
}