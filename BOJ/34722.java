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

        private final int SOLVED_BOJ_PROBLEM = 1000;
        private final int CODEFORCE_RATING = 1600;
        private final int ATCODER_RATING = 1500;
        private final int ICPC_REGION_CONTEST_RANK = 30;
        private final int ICPC_REGION_NOT_PARTICIPATE = -1;

        private int peopleNum;

        private int qualityPeople;

        public void init() throws IOException {
            peopleNum = Integer.parseInt(br.readLine());

            qualityPeople = 0;
        }

        public void solve() throws IOException {
            for (int i = 0; i < peopleNum; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int solvedProblem = Integer.parseInt(st.nextToken());
                int codeforceRating = Integer.parseInt(st.nextToken());
                int atcoderRating = Integer.parseInt(st.nextToken());
                int icpcRegionRank = Integer.parseInt(st.nextToken());

                if (SOLVED_BOJ_PROBLEM <= solvedProblem
                        || CODEFORCE_RATING <= codeforceRating
                        || ATCODER_RATING <= atcoderRating
                        || (icpcRegionRank <= ICPC_REGION_CONTEST_RANK && icpcRegionRank != ICPC_REGION_NOT_PARTICIPATE)
                ) {
                    qualityPeople++;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(qualityPeople));
            bw.flush();
        }
    }
}
