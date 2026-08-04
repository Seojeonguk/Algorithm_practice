class Solution {
    public int solution(String myString, String pat) {
        String convertedString = myString.replaceAll("A", "C")
                .replaceAll("B","A")
                .replaceAll("C","B");
        
        return convertedString.contains(pat) ? 1 : 0;
    }
}