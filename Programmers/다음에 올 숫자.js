class Solution {
    public int solution(int[] common) {
        
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];
        
        int last = common[common.length - 1];
        
        if (diff1 == diff2) {
            return last + diff1;
        } else {
            int ratio = common[1] / common[0];
            return last * ratio;
        }
    }
}