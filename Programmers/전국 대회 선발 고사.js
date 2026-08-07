import java.util.ArrayList;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int findRank = 1; findRank <= rank.length; findRank++) {
            for (int idx = 0; idx < rank.length; idx++) {
                if (rank[idx] == findRank) {
                    if (attendance[idx]) {
                        list.add(idx);
                    }
                    break;
                }
            }
        }

        return 10000 * list.get(0) + 100 * list.get(1) + list.get(2);
    }
}