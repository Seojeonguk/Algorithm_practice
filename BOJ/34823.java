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

        private int yCnt;
        private int cCnt;
        private int pCnt;

        private int makeYCPCCnt;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            yCnt = Integer.parseInt(st.nextToken());
            cCnt = Integer.parseInt(st.nextToken());
            pCnt = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            makeYCPCCnt = Math.min(yCnt, Math.min(cCnt / 2, pCnt));
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(makeYCPCCnt));
            bw.flush();
        }
    }
}
