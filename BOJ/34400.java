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

        private final int TODAY_OF_HOUR = 25;
        private final int WAKING_HOUR = 17;

        private final String ONLINE_STATUS = "ONLINE";
        private final String OFFLINE_STATUS = "OFFLINE";

        private int testCase;
        private StringBuilder result;

        public void init() throws IOException {
            testCase = Integer.parseInt(br.readLine());

            result = new StringBuilder();
        }

        public void solve() throws IOException {
            for (int tc = 0; tc < testCase; tc++) {
                int time = Integer.parseInt(br.readLine());

                time %= TODAY_OF_HOUR;
                result.append(time < WAKING_HOUR ? ONLINE_STATUS : OFFLINE_STATUS).append("\n");
            }
        }

        public void printAns() throws IOException {
            bw.write(result.toString());
            bw.flush();
        }
    }
}
