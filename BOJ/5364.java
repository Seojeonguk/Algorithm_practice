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

        int planetCnt = Integer.parseInt(br.readLine());
        int[][] planetCoordinates = new int[planetCnt][2];

        int minDistance = Integer.MAX_VALUE;
        int minDistancePlanet = -1;
        for (int i = 0; i < planetCnt; i++) {
            StringTokenizer coordinate = new StringTokenizer(br.readLine());
            planetCoordinates[i][0] = Integer.parseInt(coordinate.nextToken());
            planetCoordinates[i][1] = Integer.parseInt(coordinate.nextToken());

            if (i > 0) {
                int distance = calDistance(planetCoordinates[0], planetCoordinates[i]);
                if (distance < minDistance) {
                    minDistancePlanet = i;
                    minDistance = distance;
                }
            }
        }

        sb.append(planetCoordinates[0][0]).append(" ").append(planetCoordinates[0][1]).append("\n")
                .append(planetCoordinates[minDistancePlanet][0]).append(" ").append(planetCoordinates[minDistancePlanet][1]).append("\n")
                .append(String.format("%.2f", Math.sqrt(minDistance)));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calDistance(int[] aPlanet, int[] bPlanet) {
        int xDiff = aPlanet[0] - bPlanet[0];
        int yDiff = aPlanet[1] - bPlanet[1];

        return xDiff * xDiff + yDiff * yDiff;
    }
}
