class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] prevIdx = new int[26];
        for(int idx=0;idx<26;idx++)
            prevIdx[idx] = -1;
        
        int sSize = s.length();
        for(int idx=0;idx<sSize;idx++) {
            int nextI = s.charAt(idx)-'a';
            int diff = idx-prevIdx[nextI];
            answer[idx] = (prevIdx[nextI]== -1 ? -1 : diff);
            prevIdx[nextI] = idx;
        }
        
        return answer;
    }
}