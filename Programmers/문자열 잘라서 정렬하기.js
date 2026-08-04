import java.util.Arrays;

class Solution {
    public String[] solution(String myString) {
        String[] res = myString.split("x");
        
        Arrays.sort(res);
        
        return Arrays.stream(res).filter(x -> !"".equals(x)).toArray(String[]::new);
    }
}