import java.io.*;
import java.util.StringTokenizer;

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

        private final int BUY_FREEZE_TERM = 2;

        private int problemSolvingDay;
        private int[] solvedProblems;

        private int maxStreakDay;

        public void init() throws IOException {
            problemSolvingDay = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            solvedProblems = new int[problemSolvingDay];
            for (int i = 0; i < problemSolvingDay; i++) {
                solvedProblems[i] = Integer.parseInt(st.nextToken());
            }

            maxStreakDay = 0;
        }

        public void solve() throws IOException {
            boolean hasFreeze = true;
            int curStreakDay = 0;
            int remainedBuyFreezeTerm = 0;

            for (int i = 0; i < problemSolvingDay; i++) {
                if (!hasFreeze && remainedBuyFreezeTerm <= 0) {
                    hasFreeze = true;
                }

                if (solvedProblems[i] == 0) {
                    if (hasFreeze) {
                        hasFreeze = false;
                        remainedBuyFreezeTerm = BUY_FREEZE_TERM;
                    } else {
                        curStreakDay = 0;
                    }
                } else {
                    curStreakDay += 1;
                }

                remainedBuyFreezeTerm -= 1;
                maxStreakDay = Math.max(maxStreakDay, curStreakDay);
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(maxStreakDay));
            bw.flush();
        }
    }
}
