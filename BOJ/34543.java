import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private final int SIGHT_CNT = 5;
        private final int VISIT_SCORE = 10;
        private final int ADD_SCORE_VISIT_REFERENCE = 3;
        private final int ADD_SCORE_VISIT_OVER_REFERENCE = 20;
        private final int ADD_SCORE_VISIT_ALL = 50;
        private final int MINUS_SCORE_STEP_REFERENCE = 1000;
        private final int MINUS_SCORE_OVER_STEP_REFERENCE = 15;
        private final int MIN_SCORE = 0;

        private int visitedCnt;
        private int stepCnt;

        private int tourScore;

        public void init() throws IOException {
            visitedCnt = Integer.parseInt(br.readLine());
            stepCnt = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            tourScore = visitedCnt * VISIT_SCORE;
            if (visitedCnt >= ADD_SCORE_VISIT_REFERENCE) {
                tourScore += ADD_SCORE_VISIT_OVER_REFERENCE;
            }

            if (visitedCnt == SIGHT_CNT) {
                tourScore += ADD_SCORE_VISIT_ALL;
            }

            if (stepCnt > MINUS_SCORE_STEP_REFERENCE) {
                tourScore -= MINUS_SCORE_OVER_STEP_REFERENCE;
            }

            tourScore = Math.max(MIN_SCORE, tourScore);
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(tourScore));
            bw.flush();
        }
    }
}
