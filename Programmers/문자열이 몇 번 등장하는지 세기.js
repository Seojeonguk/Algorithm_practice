class Solution {
    public int solution(String myString, String pat) {
        int myStringLength = myString.length();
        int patLength = pat.length();

        int appearedCnt = 0;
        for (int i = 0; i <= myStringLength - patLength; i++) {
            String subString = myString.substring(i, i + patLength);
            if (subString.equals(pat)) {
                appearedCnt++;
            }
        }

        return appearedCnt;
    }
}