import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int navigationCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        long minDistance = Long.MAX_VALUE;
        int OEMNum = 0;
        for (int navigationNum = 1; navigationNum <= navigationCnt; navigationNum++) {
            int middleCnt = Integer.parseInt(br.readLine());

            long[] xIndexes = new long[middleCnt + 2];
            long[] yIndexes = new long[middleCnt + 2];

            xIndexes[0] = sx;
            yIndexes[0] = sy;

            for (int i = 1; i <= middleCnt; i++) {
                StringTokenizer middleCoordinates = new StringTokenizer(br.readLine());
                long x = Long.parseLong(middleCoordinates.nextToken());
                long y = Long.parseLong(middleCoordinates.nextToken());
                xIndexes[i] = x;
                yIndexes[i] = y;
            }

            xIndexes[middleCnt + 1] = ex;
            yIndexes[middleCnt + 1] = ey;

            long totalDistance = 0;
            for (int idx = 0; idx < xIndexes.length - 1; idx++) {
                long distance = calDistance(xIndexes[idx], yIndexes[idx], xIndexes[idx + 1], yIndexes[idx + 1]);
                totalDistance += distance;
            }

            if (minDistance >= totalDistance) {
                minDistance = totalDistance;
                OEMNum = navigationNum;
            }
        }

        sb.append(OEMNum);

        bw.write(sb.toString());
        bw.flush();
    }

    public static long calDistance(long x, long y, long nx, long ny) {
        return Math.abs(x - nx) + Math.abs(y - ny);
    }
}
