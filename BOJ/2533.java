import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int friendCnt = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] relationships = new ArrayList[friendCnt + 1];
        for (int i = 1; i <= friendCnt; i++) {
            relationships[i] = new ArrayList<>();
        }

        for (int i = 0; i < friendCnt - 1; i++) {
            StringTokenizer friendInfo = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(friendInfo.nextToken());
            int b = Integer.parseInt(friendInfo.nextToken());

            relationships[a].add(b);
            relationships[b].add(a);
        }

        int[][] dp = new int[friendCnt + 1][2];
        for (int i = 0; i <= friendCnt; i++) {
            Arrays.fill(dp[i], MAX);
        }

        int requiredEarlyAdopter = Math.min(solve(relationships, dp, 1, 0, -1), solve(relationships, dp, 1, 1, -1));

        sb.append(requiredEarlyAdopter);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(ArrayList<Integer>[] relationships, int[][] dp, int cur, int isEarlyAdopter, int prev) {
        if (dp[cur][isEarlyAdopter] != MAX) {
            return dp[cur][isEarlyAdopter];
        }

        dp[cur][isEarlyAdopter] = isEarlyAdopter;
        for (int next : relationships[cur]) {
            if (next == prev) {
                continue;
            }
            int minNext = solve(relationships, dp, next, 1, cur);
            if (isEarlyAdopter == 1) {
                minNext = Math.min(minNext, solve(relationships, dp, next, 0, cur));
            }
            dp[cur][isEarlyAdopter] += minNext;
        }

        return dp[cur][isEarlyAdopter];
    }
}
