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

        private final int LIMIT_CREDIT = 17;
        private final double LIMIT_RATING = 2.0;

        private int[] scholarships;
        private int studentCnt;

        private int spendScholarship;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            scholarships = new int[st.countTokens()];
            for (int i = 0; st.hasMoreTokens(); i++) {
                scholarships[i] = Integer.parseInt(st.nextToken());
            }

            studentCnt = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            for (int i = 0; i < studentCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int quantile = Integer.parseInt(st.nextToken());
                double rating = Double.parseDouble(st.nextToken());
                int credit = Integer.parseInt(st.nextToken());

                if (LIMIT_RATING <= rating && LIMIT_CREDIT <= credit) {
                    spendScholarship += scholarships[quantile];
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(spendScholarship));
            bw.flush();
        }
    }
}
