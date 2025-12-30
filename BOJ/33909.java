import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int SCnt;
        private int CCnt;
        private int OCnt;
        private int NCnt;

        private int canMakeBoxCnt;

        public Problem() {
            canMakeBoxCnt = 0;
        }

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer counts = new StringTokenizer(br.readLine());

                SCnt = Integer.parseInt(counts.nextToken());
                CCnt = Integer.parseInt(counts.nextToken());
                OCnt = Integer.parseInt(counts.nextToken());
                NCnt = Integer.parseInt(counts.nextToken());
            }
        }

        public void solve() {
            int SNCnt = SCnt + NCnt;
            int COCnt = CCnt + OCnt * 2;

            canMakeBoxCnt = Math.min(SNCnt / 3, COCnt / 6);
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.valueOf(canMakeBoxCnt));
                bw.flush();
            }
        }
    }
}


