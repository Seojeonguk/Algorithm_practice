import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static final int NOT_EXCELLENT_VILLAGE = 0;
    static final int EXCELLENT_VILLAGE = 1;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int villageCnt = Integer.parseInt(br.readLine());

        int[] residents = new int[villageCnt + 1];
        StringTokenizer residentTokenizer = new StringTokenizer(br.readLine());
        for (int villageNum = 1; villageNum <= villageCnt; villageNum++) {
            residents[villageNum] = Integer.parseInt(residentTokenizer.nextToken());
        }

        ArrayList<Integer>[] adj = new ArrayList[villageCnt + 1];
        for (int i = 1; i <= villageCnt; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < villageCnt - 1; i++) {
            StringTokenizer adjacentInfo = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(adjacentInfo.nextToken());
            int b = Integer.parseInt(adjacentInfo.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int[][] dp = new int[villageCnt + 1][2];
        for (int i = 0; i < villageCnt + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }

        int totalExcellentVillageResidents = Math.max(calExcellentVillageResidents(residents, adj, dp, 1, -1, 0), calExcellentVillageResidents(residents, adj, dp, 1, -1, 1));
        sb.append(totalExcellentVillageResidents);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calExcellentVillageResidents(int[] residents, ArrayList<Integer>[] adj, int[][] dp, int cur, int prev, int isExcellentVillage) {
        if (cur != 1 && adj[cur].size() == 1) {
            return (isExcellentVillage == 1 ? residents[cur] : 0);
        }

        if (dp[cur][isExcellentVillage] != -1) {
            return dp[cur][isExcellentVillage];
        }

        dp[cur][isExcellentVillage] = (isExcellentVillage == 1 ? residents[cur] : 0);

        for (int next : adj[cur]) {
            if (next == prev) {
                continue;
            }

            int maxChildExcellentVillage = calExcellentVillageResidents(residents, adj, dp, next, cur, NOT_EXCELLENT_VILLAGE);
            if (isExcellentVillage == NOT_EXCELLENT_VILLAGE) {
                maxChildExcellentVillage = Math.max(maxChildExcellentVillage, calExcellentVillageResidents(residents, adj, dp, next, cur, EXCELLENT_VILLAGE));
            }

            dp[cur][isExcellentVillage] += maxChildExcellentVillage;
        }

        return dp[cur][isExcellentVillage];
    }
}
