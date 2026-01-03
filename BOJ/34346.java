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

        private int gridSize;
        private int requiredPaintedCnt;

        public void init() throws IOException {
            gridSize = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            requiredPaintedCnt = (gridSize % 2 == 0 ? 2 : 1);
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(requiredPaintedCnt));
            bw.flush();
        }
    }
}
