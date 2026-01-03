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

        private int TEAM_MEMBER_CNT = 3;

        private int teamCnt;
        private int hasChairCnt;
        private int costPerChair;
        private int shippingCost;

        private int neededCost;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            teamCnt = Integer.parseInt(st.nextToken());
            hasChairCnt = Integer.parseInt(st.nextToken());
            costPerChair = Integer.parseInt(st.nextToken());
            shippingCost = Integer.parseInt(st.nextToken());

            neededCost = 0;
        }

        public void solve() throws IOException {
            int neededChair = Math.max(0, teamCnt * TEAM_MEMBER_CNT - hasChairCnt);

            if (neededChair > 0) {
                neededCost = neededChair * costPerChair + shippingCost;
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(neededCost));
            bw.flush();
        }
    }
}
