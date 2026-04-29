class Solution {
    public static String[] NUMBERS = {
            "zero", "one", "two", "three",
            "four", "five", "six",
            "seven", "eight", "nine"
    };

    public long solution(String numbers) {
        int idx = 0;
        long num = 0;
        while (idx < numbers.length()) {
            String subStr = numbers.substring(idx);

            for (int numIdx = 0; numIdx < NUMBERS.length; numIdx++) {
                if (subStr.startsWith(NUMBERS[numIdx])) {
                    num = num * 10 + numIdx;
                    idx += NUMBERS[numIdx].length();
                    break;
                }
            }
        }

        return num;
    }
}