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

        private int middlePlaceCnt;
        private int[] velocityLimits;

        private long sumVelocity;

        public void init() throws IOException {
            middlePlaceCnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            velocityLimits = new int[middlePlaceCnt];
            for (int i = 0; i < velocityLimits.length; i++) {
                velocityLimits[i] = Integer.parseInt(st.nextToken());
            }
        }

        public void solve() throws IOException {
            int prevVelocity = 0;
            for (int i = middlePlaceCnt - 1; i >= 0; i--) {
                int currentVelocity = Math.min(prevVelocity + 1, velocityLimits[i]);
                sumVelocity += currentVelocity;
                prevVelocity = currentVelocity;
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(sumVelocity));
            bw.flush();
        }
    }
}
