class Solution {
    public String solution(String myString) {
        char[] chars = myString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c < 'l') {
                c = 'l';
            }
            sb.append(c);
        }

        return sb.toString();
    }
}