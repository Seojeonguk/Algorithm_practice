class Solution {
    public int solution(int n, String control) {
        int ret = n;

        for (char c : control.toCharArray()) {
            if (c == 'w') {
                ret += 1;
            } else if (c == 'a') {
                ret -= 10;
            } else if (c == 's') {
                ret -= 1;
            } else if (c == 'd') {
                ret += 10;
            }
        }

        return ret;
    }
}