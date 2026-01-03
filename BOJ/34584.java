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

        private final String SAY_DOUBLE = "double it";
        private final String SAY_TAKE = "take it";

        private int startBudget;
        private int limitBudget;

        private String say;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startBudget = Integer.parseInt(st.nextToken());
            limitBudget = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            say = (startBudget * 2 <= limitBudget ? SAY_DOUBLE : SAY_TAKE);
        }

        public void printAns() throws IOException {
            bw.write(say);
            bw.flush();
        }
    }
}
