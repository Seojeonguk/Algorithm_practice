class Solution {
    public int solution(double flo) {
        String str = String.valueOf(flo);
        int ans = Integer.parseInt(str.split("\\.")[0]);
        
        return ans;
    }
}