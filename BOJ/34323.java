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

        private int discountPercentage;
        private int eventCnt;
        private int cost;

        private long minCost;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            discountPercentage = Integer.parseInt(st.nextToken());
            eventCnt = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            long eventBuyingCost = (long) eventCnt * cost;

            long originalCost = (long) (eventCnt + 1) * cost;
            long discountCost = (originalCost * discountPercentage) / 100;
            long discountResult = originalCost - discountCost - ((originalCost * discountPercentage) % 100 > 0 ? 1 : 0);

            minCost = Math.min(eventBuyingCost, discountResult);
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(minCost));
            bw.flush();
        }
    }
}
