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

        private int cnt;
        private int boxSize;

        private int requiredBoxCnt;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            boxSize = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            requiredBoxCnt = cnt / boxSize + (cnt % boxSize == 0 ? 0 : 1);
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(requiredBoxCnt));
            bw.flush();
        }
    }
}
