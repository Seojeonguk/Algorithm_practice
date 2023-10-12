import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int classroomCnt = Integer.parseInt(br.readLine());
        int totalDistance = 0;

        int[][] coordinates = new int[classroomCnt][2];
        for (int classroom = 0; classroom < classroomCnt; classroom++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[classroom][0] = x;
            coordinates[classroom][1] = y;
            if (classroom > 0) {
                int xDiff = Math.abs(coordinates[classroom - 1][0] - coordinates[classroom][0]);
                int yDiff = Math.abs(coordinates[classroom - 1][1] - coordinates[classroom][1]);

                totalDistance += xDiff + yDiff;
            }
        }

        sb.append(totalDistance);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
