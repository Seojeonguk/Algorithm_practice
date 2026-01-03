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

        private final int LATEST_YEAR = 2026;

        private int departmentCnt;

        private String selectedDepartment;

        public void init() throws IOException {
            departmentCnt = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            for (int i = 0; i < departmentCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String studyName = st.nextToken();
                int year = Integer.parseInt(st.nextToken());

                if (year == LATEST_YEAR) {
                    selectedDepartment = studyName;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(selectedDepartment);
            bw.flush();
        }
    }
}
