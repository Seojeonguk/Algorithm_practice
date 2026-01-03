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

        private final String WAKE_UP_TO_ALARM = "YES";
        private final String NOT_WAKE_UP_TO_ALARM = "NO";

        private String alarm;
        private String watchingTime;

        private String result;

        public void init() throws IOException {
            alarm = br.readLine();
            watchingTime = br.readLine();
        }

        public void solve() throws IOException {
            int alarmMin = calMinutes(alarm);
            int watchingTimeMin = calMinutes(watchingTime);

            result = (alarmMin <= watchingTimeMin ? WAKE_UP_TO_ALARM : NOT_WAKE_UP_TO_ALARM);
        }

        public int calMinutes(String time) {
            String[] timeSplit = time.split(":");
            return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
