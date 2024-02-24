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

        int cowCnt = Integer.parseInt(br.readLine());
        int[][] cowCoordinates = new int[cowCnt + 1][2];
        for (int cowNum = 1; cowNum <= cowCnt; cowNum++) {
            StringTokenizer coordinate = new StringTokenizer(br.readLine());

            for (int i = 0; i < 2; i++) {
                cowCoordinates[cowNum][i] = Integer.parseInt(coordinate.nextToken());
            }
        }

        int maxDistance = -1, maxDistanceCowNumA = -1, maxDistanceCowNumB = -1;
        for (int aCowNum = 1; aCowNum <= cowCnt; aCowNum++) {
            for (int bCowNum = aCowNum + 1; bCowNum <= cowCnt; bCowNum++) {
                int xDiff = Math.abs(cowCoordinates[aCowNum][0] - cowCoordinates[bCowNum][0]);
                int yDiff = Math.abs(cowCoordinates[aCowNum][1] - cowCoordinates[bCowNum][1]);

                int distance = xDiff * xDiff + yDiff * yDiff;
                if (maxDistance < distance) {
                    maxDistance = distance;
                    maxDistanceCowNumA = aCowNum;
                    maxDistanceCowNumB = bCowNum;
                }
            }
        }

        sb.append(maxDistanceCowNumA).append(" ").append(maxDistanceCowNumB);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
