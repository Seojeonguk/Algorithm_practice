class Solution {
    public String solution(int[] numLog) {
        String answer = "";

        for (int i = 1; i < numLog.length; i++) {
            if (numLog[i - 1] + 1 == numLog[i]) {
                answer = answer.concat("w");
            } else if (numLog[i - 1] - 1 == numLog[i]) {
                answer = answer.concat("s");
            } else if (numLog[i - 1] + 10 == numLog[i]) {
                answer = answer.concat("d");
            } else if (numLog[i - 1] - 10 == numLog[i]) {
                answer = answer.concat("a");
            }
        }
        return answer;
    }
}