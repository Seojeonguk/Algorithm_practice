import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int artistCnt = Integer.parseInt(br.readLine());
        int[][] prices = new int[artistCnt][artistCnt];
        for (int i = 0; i < artistCnt; i++) {
            String artistPrice = br.readLine();
            for (int j = 0; j < artistCnt; j++) {
                prices[i][j] = artistPrice.charAt(j) - '0';
            }
        }
        int[][][] dp = new int[artistCnt][10][(1 << artistCnt) + 1];
        for (int i = 0; i < artistCnt; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << artistCnt) + 1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int maxOwnerPicture = getMaxOwnerPicture(prices, artistCnt, 0, 0, 1, dp);
        sb.append(maxOwnerPicture);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMaxOwnerPicture(int[][] prices, int artistCnt, int current, int currentPrice, int ownerCnt, int[][][] dp) {
        int ret = dp[current][currentPrice][ownerCnt];
        if (ret != -1) {
            return ret;
        }
        dp[current][currentPrice][ownerCnt] = 1;

        int max = 0;
        for (int i = 0; i < artistCnt; i++) {
            if (((1 << i) & ownerCnt) != 0 || prices[current][i] < currentPrice) {
                continue;
            }
            max = Math.max(max, getMaxOwnerPicture(prices, artistCnt, i, prices[current][i], ownerCnt | (1 << i), dp));
        }
        dp[current][currentPrice][ownerCnt] += max;

        return dp[current][currentPrice][ownerCnt];
    }
}
