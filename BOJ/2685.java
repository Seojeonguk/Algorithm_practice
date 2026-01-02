import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
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

        private int testCaseCnt;
        private int[][] nimSums;
        private int[] nimSumResults;

        public void init() throws IOException {
            testCaseCnt = Integer.parseInt(br.readLine());
            nimSums = new int[testCaseCnt][3];
            nimSumResults = new int[testCaseCnt];

            for (int i = 0; i < testCaseCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    nimSums[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        public void solve() throws IOException {
            for (int tc = 0; tc < testCaseCnt; tc++) {
                Queue<Integer> xQueue = ConverseBase(nimSums[tc][0], nimSums[tc][1]);
                Queue<Integer> yQueue = ConverseBase(nimSums[tc][0], nimSums[tc][2]);

                Queue<Integer> sumQueue = new LinkedList<>();
                while (!xQueue.isEmpty() || !yQueue.isEmpty()) {
                    int x = xQueue.isEmpty() ? 0 : xQueue.poll();
                    int y = yQueue.isEmpty() ? 0 : yQueue.poll();

                    sumQueue.add((x + y) % nimSums[tc][0]);
                }

                int sum = 0;
                int base = 1;
                while (!sumQueue.isEmpty()) {
                    sum += (sumQueue.poll() * base);
                    base *= nimSums[tc][0];
                }
                nimSumResults[tc] = sum;
            }
        }

        public Queue<Integer> ConverseBase(int base, int x) {
            Queue<Integer> queue = new LinkedList<>();
            while (x != 0) {
                queue.add(x % base);
                x /= base;
            }

            return queue;
        }

        public void printAns() throws IOException {
            for (int i = 0; i < testCaseCnt; i++) {
                bw.write(nimSumResults[i] + "\n");
            }
            bw.flush();
        }
    }
}
