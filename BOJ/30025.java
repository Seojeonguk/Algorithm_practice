import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MOD = 1_000_000_007;
    final static int MAX_CARD_NUM = 10;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cardNum = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] canUseCards = new boolean[MAX_CARD_NUM];
        int[][] dp = new int[m + 1][k + 1];
        st = new StringTokenizer(br.readLine());
        while (cardNum-- > 0) {
            int card = Integer.parseInt(st.nextToken());
            canUseCards[card] = true;
            if (card != 0) {
                dp[1][card % k] += 1;
            }
        }

        for (int i = 2; i <= m; i++) {
            for (int card = 0; card < MAX_CARD_NUM; card++) {
                if (!canUseCards[card]) {
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    int next = j * 10 + card;
                    dp[i][next % k] = (dp[i][next % k] + dp[i - 1][j]) % MOD;
                }
            }
        }

        sb.append(dp[m][0]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
