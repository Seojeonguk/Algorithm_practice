class Solution {
 int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for (String b : babbling) {
            for (String word : words) {
                b = b.replace(word, " ");
            }

            if (b.trim().isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}