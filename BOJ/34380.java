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

        private final int FROM_FENCE_TO_BAKC_OF_ENDZONE = 10;
        private final int RUN_ENDZONE = 10;

        private int score;
        private int opponentScore;
        private int runYard;
        private int currentTemperature;

        private int totalRan;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score = Integer.parseInt(st.nextToken());
            opponentScore = Integer.parseInt(st.nextToken());
            runYard = Integer.parseInt(br.readLine());
            currentTemperature = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            totalRan = (FROM_FENCE_TO_BAKC_OF_ENDZONE + RUN_ENDZONE + runYard) * 2;
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(totalRan));
            bw.flush();
        }
    }
}
