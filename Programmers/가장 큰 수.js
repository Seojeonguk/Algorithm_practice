import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        Integer[] arr = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(arr, ((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);

            return (s2 + s1).compareTo(s1 + s2);
        }));
        
        if (arr[0] == 0) {
            return "0";
        }

        return Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}