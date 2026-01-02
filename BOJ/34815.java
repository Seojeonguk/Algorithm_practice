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

        private final String CAN_MAKE_RESULT = "YES";
        private final String CANNOT_MAKE_RESULT = "NO";

        private int n;
        private int k;

        private String result;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            result = (n % 2 == 1 && k % 2 == 1 && n == k ? CANNOT_MAKE_RESULT : CAN_MAKE_RESULT);
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
