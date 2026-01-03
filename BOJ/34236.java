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

        private int competitionCnt;
        private int[] competitionYears;

        private int nextCompetitionYear;

        public void init() throws IOException {
            competitionCnt = Integer.parseInt(br.readLine());


            StringTokenizer st = new StringTokenizer(br.readLine());
            competitionYears = new int[competitionCnt];
            for (int i = 0; i < competitionCnt; i++) {
                competitionYears[i] = Integer.parseInt(st.nextToken());
            }
        }

        public void solve() throws IOException {
            int diff = competitionYears[competitionCnt - 1] - competitionYears[competitionCnt - 2];
            nextCompetitionYear = competitionYears[competitionCnt - 1] + diff;
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(nextCompetitionYear));
            bw.flush();
        }
    }
}
