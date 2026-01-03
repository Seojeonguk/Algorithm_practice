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

        private final String YONSEI = "yonsei";
        private final String KOREA = "korea";

        private final String YONSEI_WIN_RESULT = "Yonsei Won!";
        private final String YONSEI_LOSE_RESULT = "Yonsei Lost...";

        private int participatingUnivCnt;
        private String[] univs;
        private String result;

        public void init() throws IOException {
            participatingUnivCnt = Integer.parseInt(br.readLine());

            univs = new String[participatingUnivCnt];
            for (int i = 0; i < participatingUnivCnt; i++) {
                univs[i] = br.readLine();
            }
        }

        public void solve() throws IOException {
            int koreaRank = -1;
            int yonseiRank = -1;

            for (int i = 0; i < participatingUnivCnt; i++) {
                if (YONSEI.equals(univs[i])) {
                    yonseiRank = i;
                } else if (KOREA.equals(univs[i])) {
                    koreaRank = i;
                }
            }

            result = (yonseiRank < koreaRank ? YONSEI_WIN_RESULT : YONSEI_LOSE_RESULT);
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
