class Solution {
    public long solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();

        return Long.parseLong(
            new String(
                String.valueOf(n).chars()
                    .sorted()
                    .collect(
                        StringBuilder::new,
                        (sb, c) -> sb.insert(0, (char) c),
                        (a, b) -> a.insert(0, b)
                    ).toString()
            )
        );
    }
}