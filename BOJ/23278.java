import java.io.*;
import java.util.Arrays;
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

        private int groupMemberCnt;
        private int subtractLowestScoreCnt;
        private int subtractHighestScoreCnt;
        private int[] memberScores;

        private double avg;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            groupMemberCnt = Integer.parseInt(st.nextToken());
            subtractLowestScoreCnt = Integer.parseInt(st.nextToken());
            subtractHighestScoreCnt = Integer.parseInt(st.nextToken());

            StringTokenizer scoreToken = new StringTokenizer(br.readLine());
            memberScores = new int[groupMemberCnt];
            for (int i = 0; i < groupMemberCnt; i++) {
                memberScores[i] = Integer.parseInt(scoreToken.nextToken());
            }
        }

        public void solve() throws IOException {
            int totalScore = Arrays.stream(memberScores).sum();
            Arrays.sort(memberScores);

            for (int i = 0; i < subtractLowestScoreCnt; i++) {
                totalScore -= memberScores[i];
            }

            for (int i = 0; i < subtractHighestScoreCnt; i++) {
                totalScore -= memberScores[groupMemberCnt - 1 - i];
            }

            avg = (double) totalScore / (groupMemberCnt - subtractLowestScoreCnt - subtractHighestScoreCnt);

        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(avg));
            bw.flush();
        }
    }
}
