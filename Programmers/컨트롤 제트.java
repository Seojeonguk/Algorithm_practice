public class Solution {
    public int solution(String s) {
        String[] splits = s.split(" ");

        int sum = 0;
        for (int idx = 0; idx < splits.length; idx++) {
            if ("Z".equals(splits[idx])) {
                int num = Integer.parseInt(splits[idx - 1]);
                sum -= num;
            } else {
                int num = Integer.parseInt(splits[idx]);
                sum += num;
            }
        }

        return sum;
    }
}
