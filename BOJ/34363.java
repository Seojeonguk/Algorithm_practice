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

        private static final double FEET_PER_MILE = 5280.0;
        private static final double SECONDS_PER_HOUR = 3600.0;

        private final String PASS_TEST = "MADE IT";
        private final String FAIL_TEST = "FAILED TEST";

        private int limitSpeed;
        private double distance;
        private double limitTime;

        private String result;

        public void init() throws IOException {
            limitSpeed = Integer.parseInt(br.readLine());
            distance = Double.parseDouble(br.readLine());
            limitTime = Double.parseDouble(br.readLine());
        }

        public void solve() throws IOException {
            double speedFeetPerSecond = limitSpeed * FEET_PER_MILE / SECONDS_PER_HOUR;
            double reachableDistance = speedFeetPerSecond * limitTime;
            result = (Double.compare(distance, reachableDistance) < 0) ? PASS_TEST : FAIL_TEST;
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
