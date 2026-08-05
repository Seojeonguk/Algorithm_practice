class Solution {
    public int solution(String number) {
        char[] chars = number.toCharArray();
        int sum = 0;
        for (int idx = 0; idx < chars.length; idx++) {
            sum += chars[idx] - '0';
        }

        return sum % 9;
    }
}