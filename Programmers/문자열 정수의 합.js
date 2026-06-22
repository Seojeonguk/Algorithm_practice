class Solution {
    public int solution(String num_str) {
        char[] str = num_str.toCharArray();
        
        int sum = 0;
        for(char c : str) {
            sum += (c - '0');
        }
        
        return sum;
    }
}