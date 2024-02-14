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

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer stationInfo = new StringTokenizer(br.readLine());
            int stationCnt = Integer.parseInt(stationInfo.nextToken());
            int passedStationCnt = Integer.parseInt(stationInfo.nextToken());

            int[][] stationCoordinates = new int[stationCnt + 1][2];
            for (int stationNum = 1; stationNum <= stationCnt; stationNum++) {
                StringTokenizer coordinate = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(coordinate.nextToken());
                int y = Integer.parseInt(coordinate.nextToken());
                stationCoordinates[stationNum][0] = x;
                stationCoordinates[stationNum][1] = y;
            }

            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
            StringTokenizer passedStationInfo = new StringTokenizer(br.readLine());
            for (int i = 0; i < passedStationCnt; i++) {
                int passedStationNum = Integer.parseInt(passedStationInfo.nextToken());
                minX = Math.min(minX, stationCoordinates[passedStationNum][0]);
                maxX = Math.max(maxX, stationCoordinates[passedStationNum][0]);
                minY = Math.min(minY, stationCoordinates[passedStationNum][1]);
                maxY = Math.max(maxY, stationCoordinates[passedStationNum][1]);
            }

            int isInSquareCnt = 0;
            for (int stationNum = 1; stationNum <= stationCnt; stationNum++) {
                if (isInSquare(stationCoordinates[stationNum], minX, maxX, minY, maxY)) {
                    isInSquareCnt++;
                }
            }

            sb.append("Data Set ").append(tc).append(":\n").append(isInSquareCnt).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isInSquare(int[] stationCoordinate, int minX, int maxX, int minY, int maxY) {
        int x = stationCoordinate[0];
        int y = stationCoordinate[1];
        return (minX <= x && x <= maxX && minY <= y && y <= maxY);
    }
}
