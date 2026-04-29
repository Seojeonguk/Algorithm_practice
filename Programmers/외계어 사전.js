import java.util.Arrays;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String target = String.join("", spell);

        for (String word : dic) {
            String[] chars = word.split("");
            Arrays.sort(chars);

            if (target.equals(String.join("", chars))) {
                return 1;
            }
        }

        return 2;
    }
}