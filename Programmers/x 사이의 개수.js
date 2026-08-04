import java.util.Arrays;

class Solution {
    public int[] solution(String myString) {
        int[] temp = Arrays.stream(myString.split("x"))
                .mapToInt(String::length)
                .toArray();
        
        int size = temp.length;
        if(myString.endsWith("x")) {
            size = temp.length + 1;
        }
        
        int[] res = new int[size];
        System.arraycopy(temp, 0, res, 0, temp.length);
        
        return res;
    }
}