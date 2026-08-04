import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length)
                .filter(idx -> !finished[idx])
                .mapToObj(idx -> todo_list[idx])
                .toArray(String[]::new);
    }
}