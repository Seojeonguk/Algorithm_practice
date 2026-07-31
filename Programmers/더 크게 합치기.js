class Solution {
    public int solution(int a, int b) {
        int aFirst = Integer.parseInt(String.valueOf(a) + b);
        int bFirst = Integer.parseInt(String.valueOf(b) + a);

        return Math.max(aFirst, bFirst);
    }
}