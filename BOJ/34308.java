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

        private int maxBuyingApple;
        private int tripStoreCnt;
        private int[] neededApples;

        private int[] buyingApples;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            maxBuyingApple = Integer.parseInt(st.nextToken());
            tripStoreCnt = Integer.parseInt(st.nextToken());

            StringTokenizer neededAppleToken = new StringTokenizer(br.readLine());
            neededApples = new int[tripStoreCnt];
            for (int i = 0; i < neededApples.length; i++) {
                neededApples[i] = Integer.parseInt(neededAppleToken.nextToken());
            }

            buyingApples = new int[tripStoreCnt];
        }

        public void solve() throws IOException {
            for (int i = 0; i < tripStoreCnt; i++) {
                int diffMaxApple = maxBuyingApple - neededApples[i];
                int diffMinApple = neededApples[i] - 1;

                buyingApples[i] = (diffMaxApple < diffMinApple ? maxBuyingApple : 1);
            }
        }

        public void printAns() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tripStoreCnt; i++) {
                sb.append(buyingApples[i]).append(" ");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
