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

        private final char PLUS = '+';
        private final char MINUS = '-';

        private int availableDonuts;
        private int eventCnt;

        public void init() throws IOException {
            availableDonuts = Integer.parseInt(br.readLine());
            eventCnt = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            for (int i = 0; i < eventCnt; i++) {
                char c = br.readLine().charAt(0);
                int donuts = Integer.parseInt(br.readLine());

                if (PLUS == c) {
                    availableDonuts += donuts;
                } else if (MINUS == c) {
                    availableDonuts -= donuts;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(availableDonuts));
            bw.flush();
        }
    }
}
