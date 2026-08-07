class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            StringBuilder sb = new StringBuilder(my_string.substring(query[0], query[1] + 1))
                    .reverse()
                    .insert(0, my_string.substring(0, query[0]))
                    .append(my_string.substring(query[1] + 1));

            my_string = sb.toString();
        }

        return my_string;
    }
}