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

        private final int MILE_TO_FEET = 5280;

        private int mile;
        private int waterGunInterval;

        private int squiredCnt;

        public void init() throws IOException {
            mile = Integer.parseInt(br.readLine());
            waterGunInterval = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            squiredCnt = (mile * MILE_TO_FEET) / waterGunInterval;
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(squiredCnt));
            bw.flush();
        }
    }
}
