class Solution {
    public int solution(int a, int b) {
        int joinIntRes = joinInt(a, b);
        int multipleRes = multiple(a, b);

        return Math.max(joinIntRes, multipleRes);
    }
    
    public int joinInt(int a, int b) {
        return Integer.parseInt(a + String.valueOf(b));
    }

    public int multiple(int a, int b) {
        return 2 * a * b;
    }
}