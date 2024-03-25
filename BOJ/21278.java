import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_DISTANCE = 100;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int buildingCnt = Integer.parseInt(st.nextToken());
        int roadCnt = Integer.parseInt(st.nextToken());

        int[][] minDistances = new int[buildingCnt + 1][buildingCnt + 1];
        for (int i = 1; i <= buildingCnt; i++) {
            Arrays.fill(minDistances[i], MAX_DISTANCE + 1);
        }

        for (int i = 0; i < roadCnt; i++) {
            StringTokenizer roadInfo = new StringTokenizer(br.readLine());
            int aBuilding = Integer.parseInt(roadInfo.nextToken());
            int bBuilding = Integer.parseInt(roadInfo.nextToken());

            minDistances[aBuilding][bBuilding] = minDistances[bBuilding][aBuilding] = 1;
        }

        for (int k = 1; k <= buildingCnt; k++) {
            for (int i = 1; i <= buildingCnt; i++) {
                for (int j = 1; j <= buildingCnt; j++) {
                    if (minDistances[i][k] + minDistances[k][j] < minDistances[i][j]) {
                        minDistances[i][j] = minDistances[i][k] + minDistances[k][j];
                    }
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int[] minDistanceBuildings = new int[2];

        for (int i = 1; i <= buildingCnt; i++) {
            for (int j = i + 1; j <= buildingCnt; j++) {
                int distance = 0;
                for (int k = 1; k <= buildingCnt; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    distance += Math.min(minDistances[i][k], minDistances[j][k]);
                }
                if (distance < minDistance) {
                    minDistance = distance;
                    minDistanceBuildings[0] = i;
                    minDistanceBuildings[1] = j;
                }
            }
        }

        sb.append(minDistanceBuildings[0]).append(" ").append(minDistanceBuildings[1]).append(" ").append(minDistance * 2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
