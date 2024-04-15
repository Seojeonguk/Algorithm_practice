import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static final int NOT_INDEPENDENT_SET = 0;
    static final int INDEPENDENT_SET = 1;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int peakCnt = Integer.parseInt(br.readLine());

        int[] weights = new int[peakCnt + 1];
        StringTokenizer weightInfo = new StringTokenizer(br.readLine());
        for (int peakNum = 1; peakNum <= peakCnt; peakNum++) {
            weights[peakNum] = Integer.parseInt(weightInfo.nextToken());
        }

        ArrayList<Integer>[] adj = new ArrayList[peakCnt + 1];
        for (int i = 1; i <= peakCnt; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < peakCnt - 1; i++) {
            StringTokenizer adjacentInfo = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(adjacentInfo.nextToken());
            int b = Integer.parseInt(adjacentInfo.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int[][] dp = new int[peakCnt + 1][2];
        for (int i = 0; i < peakCnt + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }

        int maxIndependentSet = Math.max(calMaxIndependentSet(weights, adj, dp, 1, 0, 0), calMaxIndependentSet(weights, adj, dp, 1, 0, 1));
        sb.append(maxIndependentSet).append("\n");

        ArrayList<Integer> independentPeaks = new ArrayList<>();
        boolean[] isVisited = new boolean[peakCnt + 1];
        tracing(independentPeaks, adj, dp, 1, 0, isVisited);

        Collections.sort(independentPeaks);

        for (int peak : independentPeaks) {
            sb.append(peak).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calMaxIndependentSet(int[] weights, ArrayList<Integer>[] adj, int[][] dp, int cur, int prev, int isIndependentSet) {
        if (dp[cur][isIndependentSet] != -1) {
            return dp[cur][isIndependentSet];
        }

        dp[cur][isIndependentSet] = (isIndependentSet == 1 ? weights[cur] : 0);

        for (int next : adj[cur]) {
            if (next == prev) {
                continue;
            }

            int maxChildIndependentSet = calMaxIndependentSet(weights, adj, dp, next, cur, NOT_INDEPENDENT_SET);
            if (isIndependentSet == NOT_INDEPENDENT_SET) {
                int childIndependentSet = calMaxIndependentSet(weights, adj, dp, next, cur, INDEPENDENT_SET);
                if (maxChildIndependentSet < childIndependentSet) {
                    maxChildIndependentSet = childIndependentSet;
                }
            }

            dp[cur][isIndependentSet] += maxChildIndependentSet;
        }

        return dp[cur][isIndependentSet];
    }

    public static void tracing(ArrayList<Integer> independentPeaks, ArrayList<Integer>[] adj, int[][] dp, int cur, int prev, boolean[] isVisit) {
        if (dp[cur][1] > dp[cur][0] && !isVisit[prev]) {
            independentPeaks.add(cur);
            isVisit[cur] = true;
        }

        for (int next : adj[cur]) {
            if (next == prev) {
                continue;
            }

            tracing(independentPeaks, adj, dp, next, cur, isVisit);
        }
    }
}
