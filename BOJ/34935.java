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

        private int dataCnt;
        private long[] datas;

        private boolean isAscending;

        public void init() throws IOException {
            dataCnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            datas = new long[dataCnt];
            for (int i = 0; i < dataCnt; i++) {
                datas[i] = Long.parseLong(st.nextToken());
            }
        }

        public void solve() throws IOException {
            isAscending = true;
            for (int i = 1; i < dataCnt; i++) {
                if (datas[i - 1] >= datas[i]) {
                    isAscending = false;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(isAscending ? 1 : 0));
            bw.flush();
        }
    }
}
