import java.util.TreeSet;

class Solution {
    public int[] solution(int[][] score) {
        TreeSet<Double> avgs = new TreeSet<>();
        for (int i = 0; i < score.length; i++) {
            double avg = (score[i][0] + score[i][1]) / 2.0;
            avgs.add(avg);
        }

        int[] ranks = new int[score.length];
        int curRank = 1;
        while (!avgs.isEmpty()) {
            double curAvg = avgs.pollLast();
            int sameCnt = 0;
            for (int i = 0; i < score.length; i++) {
                double avg = (score[i][0] + score[i][1]) / 2.0;
                if (avg == curAvg) {
                    ranks[i] = curRank;
                    sameCnt++;
                }
            }

            curRank += sameCnt;
        }

        return ranks;
    }
}