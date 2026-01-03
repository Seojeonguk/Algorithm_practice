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

        private final int PERCENTAGE_OVER_1000000 = 20;
        private final int PERCENTAGE_OVER_500000 = 15;
        private final int PERCENTAGE_OVER_100000 = 10;
        private final int PERCENTAGE_UNDER_100000 = 5;

        private int receivedMoney;

        private int giveMoney;
        private int getMoney;

        public void init() throws IOException {
            receivedMoney = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            if (1000000 <= receivedMoney) {
                giveMoney = (receivedMoney * PERCENTAGE_OVER_1000000) / 100;
            } else if (500000 <= receivedMoney) {
                giveMoney = (receivedMoney * PERCENTAGE_OVER_500000) / 100;
            } else if (100000 <= receivedMoney) {
                giveMoney = (receivedMoney * PERCENTAGE_OVER_100000) / 100;
            } else {
                giveMoney = (receivedMoney * PERCENTAGE_UNDER_100000) / 100;
            }

            getMoney = receivedMoney - giveMoney;
        }

        public void printAns() throws IOException {
            bw.write(String.format("%d %d", giveMoney, getMoney));
            bw.flush();
        }
    }
}
