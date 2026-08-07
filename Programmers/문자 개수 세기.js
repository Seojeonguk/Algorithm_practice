class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        int length = my_string.length();
        for (int idx = 0; idx < length; idx++) {
            char c = my_string.charAt(idx);
            if (Character.isUpperCase(c)) {
                answer[c - 'A']++;
            } else {
                answer[26 + c - 'a']++;
            }
        }
        return answer;
    }
}