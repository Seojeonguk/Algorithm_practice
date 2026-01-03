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

        private final int TOTAL_LINE = 10000;

        public void init() throws IOException {
            br.readLine();
            br.readLine();
            br.readLine();
        }

        public void solve() throws IOException {
            for (int i = 0; i < TOTAL_LINE; i++) {
                bw.write(String.valueOf(-1) + "\n");
            }

        }

        public void printAns() throws IOException {
            bw.flush();
        }
    }
}
