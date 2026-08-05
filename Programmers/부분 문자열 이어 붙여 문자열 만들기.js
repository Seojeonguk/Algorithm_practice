class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";

        for (int idx = 0; idx < my_strings.length; idx++) {
            answer = answer.concat(my_strings[idx].substring(parts[idx][0], parts[idx][1] + 1));
        }

        return answer;
    }
}