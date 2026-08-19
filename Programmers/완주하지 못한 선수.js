import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int ans = 0;
        for (ans = 0; ans < completion.length; ans++) {
            if (!completion[ans].equals(participant[ans])) {
                break;
            }
        }

        return participant[ans];
    }
}