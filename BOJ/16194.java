import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1000 * 10000 + 100;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cardCnt = Integer.parseInt(br.readLine());
        int[] prices = new int[cardCnt + 1];
        StringTokenizer cardPriceInfo = new StringTokenizer(br.readLine());
        for (int cardNum = 1; cardNum <= cardCnt; cardNum++) {
            prices[cardNum] = Integer.parseInt(cardPriceInfo.nextToken());
        }

        int[] dp = new int[cardCnt + 1];
        Arrays.fill(dp, MAX);

        solve(dp, prices, cardCnt);

        sb.append(dp[cardCnt]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int[] dp, int[] prices, int cardCnt) {
        if (cardCnt == 0) {
            return 0;
        }

        if (dp[cardCnt] != MAX) {
            return dp[cardCnt];
        }

        int minPrice = MAX - 10;
        for (int i = 1; i <= cardCnt; i++) {
            minPrice = Math.min(minPrice, solve(dp, prices, cardCnt - i) + prices[i]);
        }

        return dp[cardCnt] = minPrice;
    }
}
