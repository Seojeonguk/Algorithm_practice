class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for (int i = 0; i < picture.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = picture[i].toCharArray();
            for (int idx = 0; idx < chars.length; idx++) {
                for (int rec = 0; rec < k; rec++) {
                    sb.append(chars[idx]);
                }
            }

            for (int rec = 0; rec < k; rec++) {
                answer[i * k + rec] = sb.toString();
            }
        }
        
        return answer;
    }
}