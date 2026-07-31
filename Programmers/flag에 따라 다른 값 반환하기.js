class Solution {
    public int solution(int a, int b, boolean flag) {
        int result = a + b;
        if (!flag) {
            result = a - b;
        }

        return result;
    }
}