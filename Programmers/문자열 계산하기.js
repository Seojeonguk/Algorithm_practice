class Solution {
    public int solution(String my_string) {
        String[] splits = my_string.split(" ");
        int sum = Integer.parseInt(splits[0]);
        for (int i = 1; i < splits.length; i += 2) {
            if ("+".equals(splits[i])) {
                sum += Integer.parseInt(splits[i + 1]);
            } else {
                sum -= Integer.parseInt(splits[i + 1]);
            }
        }

        return sum;
    }
}