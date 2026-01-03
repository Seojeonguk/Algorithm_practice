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

        private final int LIMIT_HEIGHT = 48;
        private final String PASS_LIMIT_ALL = "True";
        private final String NOT_PASS_LIMIT_ALL = "False";

        private int receiveHeightCnt;
        private int[] heights;

        private String result;

        public void init() throws IOException {
            receiveHeightCnt = Integer.parseInt(br.readLine());

            heights = new int[receiveHeightCnt];
            for (int i = 0; i < receiveHeightCnt; i++) {
                heights[i] = Integer.parseInt(br.readLine());
            }
        }

        public void solve() throws IOException {
            result = PASS_LIMIT_ALL;

            for (int i = 0; i < receiveHeightCnt; i++) {
                if (heights[i] < LIMIT_HEIGHT) {
                    result = NOT_PASS_LIMIT_ALL;
                    break;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
