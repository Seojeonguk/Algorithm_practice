class Solution {
    public int solution(int[] num_list) {
        int multi = 1;
        int sum = 0;
        for(int x : num_list) {
            multi *= x;
            sum += x;
        }
        
        return multi < sum * sum ? 1 : 0;
    }
}