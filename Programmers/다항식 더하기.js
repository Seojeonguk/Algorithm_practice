class Solution {
    public String solution(String polynomial) {
        String[] splits = polynomial.split(" ");
        int x = 0;
        int y = 0;
        for (int i = 0; i < splits.length; i += 2) {
            String s = splits[i];
            if (s.contains("x")) {
                if (s.length() == 1) {
                    x++;
                } else {
                    x += Integer.parseInt(s.substring(0, s.length() - 1));
                }
            } else {
                y += Integer.parseInt(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (x > 0) {
            if (x > 1) {
                sb.append(x);
            }
            sb.append("x");

            if (y > 0) {
                sb.append(" + ");
            }
        }

        if (y > 0) {
            sb.append(y);
        }

        return sb.toString();
    }
}