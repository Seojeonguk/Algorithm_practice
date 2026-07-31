class Solution {
    public String solution(String s) {
        String[] splits = s.split(" ");

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < splits.length; i++) {
            long num = Long.parseLong(splits[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return min + " " + max;
    }
}