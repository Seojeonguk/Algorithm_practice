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

        private int rowSize;
        private int colSize;

        private int maxNum;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            if (1 < rowSize && 1 < colSize) {
                maxNum = 4;
            } else if (1 < rowSize || 1 < colSize) {
                maxNum = 2;
            } else {
                maxNum = 1;
            }
        }

        public void printAns() throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append(maxNum).append("\n");
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (colSize == 1) {
                        sb.append(i % 2 + 1);
                    } else {
                        sb.append((i % 2) * 2 + (j % 2) + 1).append(" ");
                    }
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}
