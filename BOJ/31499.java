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

        private int n;
        private int mod;

        private long fractalCnt;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            mod = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            fractalCnt = 1;
            for (int i = 1; i <= n; i++) {
                fractalCnt = (fractalCnt * i) % mod;
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(fractalCnt));
            bw.flush();
        }
    }
}
