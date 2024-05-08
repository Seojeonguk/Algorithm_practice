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

            StringTokenizer starts = new StringTokenizer(br.readLine());
            long sx = Long.parseLong(starts.nextToken());
            long sy = Long.parseLong(starts.nextToken());

            StringTokenizer ends = new StringTokenizer(br.readLine());
            long ex = Long.parseLong(ends.nextToken());
            long ey = Long.parseLong(ends.nextToken());

            long ans = dist(sx, sy, ex, ey);
            long[][] teleports = new long[3][4];
            for (int i = 0; i < 3; i++) {
                StringTokenizer teleport = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    teleports[i][j] = Long.parseLong(teleport.nextToken());
                }
            }

            boolean[] selected = new boolean[3];
            ans = Math.min(ans, calMinDist(sx, sy, ex, ey, teleports, selected));

            sb.append(ans);

            bw.write(sb.toString());
        }
    }

    public static long calMinDist(long x, long y, long ex, long ey, long[][] teleports, boolean[] selected) {
        long minDist = dist(x, y, ex, ey);
        for (int i = 0; i < 3; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            minDist = Math.min(minDist, calMinDist(teleports[i][2], teleports[i][3], ex, ey, teleports, selected) + dist(x, y, teleports[i][0], teleports[i][1]) + 10);
            minDist = Math.min(minDist, calMinDist(teleports[i][0], teleports[i][1], ex, ey, teleports, selected) + dist(x, y, teleports[i][2], teleports[i][3]) + 10);
            selected[i] = false;
        }

        return minDist;
    }


    public static long dist(long x1, long y1, long x2, long y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
