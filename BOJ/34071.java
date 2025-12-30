import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int problemCnt;
        private int startLevel;
        private int compareLevel;

        private int harderCnt;
        private int easierCnt;

        private String result;

        private final String FIRST_HARDEST_PROBLEM = "hard";
        private final String FIRST_EASIER_PROBLEM = "ez";
        private final String FIRST_MIDDLE_LEVEL_PROBLEM = "?";

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                problemCnt = Integer.parseInt(br.readLine());
                startLevel = Integer.parseInt(br.readLine());

                for (int i = 0; i < problemCnt - 1; i++) {
                    compareLevel = Integer.parseInt(br.readLine());

                    if (startLevel < compareLevel) {
                        easierCnt++;
                    } else {
                        harderCnt++;
                    }
                }
            }
        }

        public void solve() {
            if (easierCnt == problemCnt - 1) {
                result = FIRST_EASIER_PROBLEM;
            } else if (harderCnt == problemCnt - 1) {
                result = FIRST_HARDEST_PROBLEM;
            } else {
                result = FIRST_MIDDLE_LEVEL_PROBLEM;
            }
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(result);
                bw.flush();
            }
        }
    }
}


