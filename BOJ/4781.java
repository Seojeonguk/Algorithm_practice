import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_MONEY = 10000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[MAX_MONEY + 1];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int candyCnt = Integer.parseInt(st.nextToken());
            String[] moneys = st.nextToken().split("\\.");
            int hasMoney = Integer.parseInt(moneys[0]) * 100 + Integer.parseInt(moneys[1]);

            if (candyCnt == 0) {
                break;
            }

            Arrays.fill(dp, 0);
            for (int candyNum = 0; candyNum < candyCnt; candyNum++) {
                StringTokenizer candyInfo = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(candyInfo.nextToken());
                String[] prices = candyInfo.nextToken().split("\\.");
                int price = Integer.parseInt(prices[0]) * 100 + Integer.parseInt(prices[1]);

                for (int j = price; j <= hasMoney; j++) {
                    dp[j] = Math.max(dp[j], calorie + dp[j - price]);
                }
            }

            sb.append(dp[hasMoney]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
