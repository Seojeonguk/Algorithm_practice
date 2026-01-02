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

        private final int TOTAL_PLACE = 4;
        private final int PERSON_CNT = 3;
        private int[][] coordinates;
        private boolean[] isVisit;

        private double minDistance = Double.MAX_VALUE;

        public void init() throws IOException {
            coordinates = new int[TOTAL_PLACE][2];
            isVisit = new boolean[TOTAL_PLACE];

            for (int i = 0; i < TOTAL_PLACE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coordinates[i][0] = Integer.parseInt(st.nextToken());
                coordinates[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        public void solve() throws IOException {
            calMinDistance(coordinates[0], 0, 0);
        }

        public void calMinDistance(int[] cur, int step, double sumDistance) {
            if (step == PERSON_CNT) {
                minDistance = Math.min(minDistance, sumDistance);
                return;
            }

            for (int i = 1; i <= PERSON_CNT; i++) {
                if (isVisit[i]) {
                    continue;
                }

                isVisit[i] = true;
                double distance = calDistance(cur, coordinates[i]);
                calMinDistance(coordinates[i], step + 1, sumDistance + distance);
                isVisit[i] = false;
            }
        }

        public double calDistance(int[] a, int[] b) {
            return Math.sqrt(pow(Math.abs(a[0] - b[0])) + pow(Math.abs(a[1] - b[1])));
        }

        public int pow(int x) {
            return x * x;
        }

        public void printAns() throws IOException {
            bw.write(String.format("%d\n", (int) Math.floor(minDistance)));
            bw.flush();
        }
    }
}
