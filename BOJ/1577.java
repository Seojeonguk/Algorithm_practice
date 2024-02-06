import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int mSize = Integer.parseInt(st.nextToken());
        int nSize = Integer.parseInt(st.nextToken());

        int constructionRoadCnt = Integer.parseInt(br.readLine());
        boolean[][][] isBlock = new boolean[nSize + 3][mSize + 3][2];
        for (int i = 0; i < constructionRoadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (a == c) {
                isBlock[Math.max(b, d) + 1][a + 1][0] = true;
            } else {
                isBlock[d + 1][Math.max(a, c) + 1][1] = true;
            }
        }

        long reachingDestinationWayCnt = calReachingDestinationWayCnt(nSize, mSize, isBlock);
        sb.append(reachingDestinationWayCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calReachingDestinationWayCnt(int nSize, int mSize, boolean[][][] isBlock) {
        long[][] dp = new long[nSize + 3][mSize + 3];
        dp[0][1] = 1;
        for (int n = 1; n <= nSize + 1; n++) {
            for (int m = 1; m <= mSize + 1; m++) {
                if (!isBlock[n][m][0]) {
                    dp[n][m] += dp[n - 1][m];
                }
                if (!isBlock[n][m][1]) {
                    dp[n][m] += dp[n][m - 1];
                }
            }
        }

        return dp[nSize + 1][mSize + 1];
    }
}
