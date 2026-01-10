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

        private int testCase;
        private long[] xValues;

        private long[] ans;

        public void init() throws IOException {
            testCase = Integer.parseInt(br.readLine());

            xValues = new long[testCase];
            ans = new long[testCase];
            for (int i = 0; i < testCase; i++) {
                xValues[i] = Long.parseLong(br.readLine());
            }
        }

        public void solve() throws IOException {
            for (int i = 0; i < testCase; i++) {
                ans[i] = calTime(xValues[i]);
            }
        }

        public long calTime(long x) {
            if (x == 0) {
                return 0;
            }

            long cur = 1;
            long absX = Math.abs(x);
            while (cur < absX) {
                cur *= 2;
            }

            long ret = (cur - 1) * 4 + absX;
            if (x < 0) {
                ret += cur * 2;
            }

            return ret;
        }

        public void printAns() throws IOException {
            for (int i = 0; i < testCase; i++) {
                bw.write(ans[i] + "\n");
            }
            bw.flush();
        }
    }
}
