class Solution {
    public String solution(String code) {
        char[] chars = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isSkipEven = false;
        for (int idx = 0; idx < chars.length; idx++) {
            char c = chars[idx];

            if (c == '1') {
                isSkipEven = !isSkipEven;
            } else {
                if (isSkipEven && idx % 2 == 1) {
                    sb.append(c);
                } else if (!isSkipEven && idx % 2 == 0) {
                    sb.append(c);
                }
            }
        }
        
        if (sb.isEmpty()) {
            return "EMPTY";
        }
        
        return sb.toString();
    }
}