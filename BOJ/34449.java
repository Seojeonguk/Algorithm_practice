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

        private final double PI = 3.14159;

        private final String ENOUGH_ROOM = "YES";
        private final String NOT_ENOUGH_ROOM = "NO";

        private double tableRadius;
        private double requiredArea;
        private int knightCnt;

        private String result;

        public void init() throws IOException {
            tableRadius = Double.parseDouble(br.readLine());
            requiredArea = Double.parseDouble(br.readLine());
            knightCnt = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            double tableArea = PI * tableRadius;
            double requiredTotalArea = requiredArea * knightCnt;

            result = Double.compare(tableArea, requiredTotalArea) < 0 ? NOT_ENOUGH_ROOM : ENOUGH_ROOM;
        }

        public void printAns() throws IOException {
            bw.write(result);
            bw.flush();
        }
    }
}
