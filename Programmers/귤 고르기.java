import java.util.*;
class Solution {
        public static int solution(int k, int[] tangerine) {
        Map<Integer,Integer> m = new HashMap<>();

        Arrays.stream(tangerine).forEach((orange) -> {
            int cnt=1;
            if(m.containsKey(orange))
                cnt += m.get(orange);
            m.put(orange,cnt);
        });

        List<Integer> l = new ArrayList<Integer>();
        m.forEach((key, value)-> {
            l.add(value);
        });

        l.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });

        int answer=0;
        for(int cnt : l) {
            answer++;
            k-=cnt;
            if(k<=0)
                break;
        }


        return answer;
    }
}