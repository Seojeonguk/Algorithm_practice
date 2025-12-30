import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private final int AUnit = 100;
        private final int BUnit = 50;
        private final int CUnit = 20;

        private int APrice;
        private int BPrice;
        private int CPrice;

        private int ABuyingWeight;
        private int BBuyingWeight;
        private int CBuyingWeight;

        private int totalPrice;

        public Problem() {
            this.totalPrice = 0;
        }

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer prices = new StringTokenizer(br.readLine());

                APrice = Integer.parseInt(prices.nextToken());
                BPrice = Integer.parseInt(prices.nextToken());
                CPrice = Integer.parseInt(prices.nextToken());

                StringTokenizer buyingWeights = new StringTokenizer(br.readLine());
                ABuyingWeight = Integer.parseInt(buyingWeights.nextToken());
                BBuyingWeight = Integer.parseInt(buyingWeights.nextToken());
                CBuyingWeight = Integer.parseInt(buyingWeights.nextToken());
            }
        }

        public void solve() {
            totalPrice = calPrice(ABuyingWeight, APrice, AUnit)
                    + calPrice(BBuyingWeight, BPrice, BUnit)
                    + calPrice(CBuyingWeight, CPrice, CUnit);
        }

        public int calPrice(int buyingWeight, int price, int unit) {
            return (buyingWeight / unit) * price;
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.valueOf(totalPrice));
                bw.flush();
            }
        }
    }
}


