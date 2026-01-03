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

        private final String NOT_LATE = "~.~";
        private final String LATE = "T.T";
        private final String SHUTTLE_NOT_LATE = "Shuttle";
        private final String WALKING_NOT_LATE = "Walk";

        private int waitingShuttleTime;
        private int takingShuttleTime;
        private int takingWalkingTime;
        private int remainingTime;

        private String result;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            waitingShuttleTime = Integer.parseInt(st.nextToken());
            takingShuttleTime = Integer.parseInt(st.nextToken());
            takingWalkingTime = Integer.parseInt(st.nextToken());
            remainingTime = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            boolean isNotLateShuttle = (waitingShuttleTime + takingShuttleTime <= remainingTime);
            boolean isNotLateWalking = (takingWalkingTime <= remainingTime);

            if (isNotLateShuttle && isNotLateWalking) {
                result = NOT_LATE;
            } else if (isNotLateShuttle) {
                result = SHUTTLE_NOT_LATE;
            } else if (isNotLateWalking) {
                result = WALKING_NOT_LATE;
            } else {
                result = LATE;
            }
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
