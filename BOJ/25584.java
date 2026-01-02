import java.io.*;
import java.util.HashMap;
import java.util.Map;
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

        private final int[] WORKING_TIMES = {4, 6, 4, 10};
        private final String NOT_WORK_NAME = "-";

        private final String FAIR_WORK = "Yes";
        private final String NOT_FAIR_WORK = "No";

        private final int FAIR_CRITERION_TIME = 12;

        private int weeks;
        private Map<String, Integer> workTimesByName = new HashMap<>();
        private String result;


        public void init() throws IOException {
            weeks = Integer.parseInt(br.readLine());

            for (int week = 0; week < weeks; week++) {
                for (int i = 0; i < 4; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while (st.hasMoreTokens()) {
                        String name = st.nextToken();
                        if (NOT_WORK_NAME.equals(name)) {
                            continue;
                        }
                        int workTime = workTimesByName.getOrDefault(name, 0) + WORKING_TIMES[i];
                        workTimesByName.put(name, workTime);
                    }
                }
            }
        }

        public void solve() throws IOException {
            int minWorkTime = Integer.MAX_VALUE;
            int maxWorkTime = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : workTimesByName.entrySet()) {
                minWorkTime = Math.min(minWorkTime, entry.getValue());
                maxWorkTime = Math.max(maxWorkTime, entry.getValue());
            }

            result = (Math.abs(maxWorkTime - minWorkTime) <= FAIR_CRITERION_TIME ? FAIR_WORK : NOT_FAIR_WORK);
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
