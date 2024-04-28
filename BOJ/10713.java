import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken());
            int visitedCityCnt = Integer.parseInt(st.nextToken());

            int[] visitedCities = new int[visitedCityCnt];
            int[] prefixSums = new int[cityCnt + 1];
            StringTokenizer visitedCitiesTokenizer = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < visitedCityCnt; idx++) {
                visitedCities[idx] = Integer.parseInt(visitedCitiesTokenizer.nextToken());
                if (idx > 0) {
                    prefixSums[Math.min(visitedCities[idx - 1], visitedCities[idx])]++;
                    prefixSums[Math.max(visitedCities[idx - 1], visitedCities[idx])]--;
                }
            }

            for (int i = 1; i < cityCnt; i++) {
                prefixSums[i] += prefixSums[i - 1];
            }

            int[][] moveCosts = new int[cityCnt + 1][3];
            for (int i = 1; i < cityCnt; i++) {
                StringTokenizer costInfo = new StringTokenizer(br.readLine());
                moveCosts[i][0] = Integer.parseInt(costInfo.nextToken());
                moveCosts[i][1] = Integer.parseInt(costInfo.nextToken());
                moveCosts[i][2] = Integer.parseInt(costInfo.nextToken());
            }

            long minCost = 0;
            for (int idx = 1; idx < cityCnt; idx++) {
                minCost += Math.min((long) moveCosts[idx][0] * prefixSums[idx], (long) moveCosts[idx][2] + (long) moveCosts[idx][1] * prefixSums[idx]);
            }

            sb.append(minCost);

            bw.write(sb.toString());
        }
    }
}
