import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        boolean[][] isOnDragonCurve = new boolean[300][300];

        int dragonCurveCnt = Integer.parseInt(br.readLine());
        while (dragonCurveCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken()) + 100;
            int endY = Integer.parseInt(st.nextToken()) + 100;
            int direction = Integer.parseInt(st.nextToken());
            int period = Integer.parseInt(st.nextToken());

            ArrayList<Integer> dragonCurveDirections = new ArrayList<>();
            isOnDragonCurve[endX][endY] = true;
            endX += DIRS[direction][0];
            endY += DIRS[direction][1];
            isOnDragonCurve[endX][endY] = true;
            dragonCurveDirections.add(direction);

            while (period-- > 0) {
                for (int idx = dragonCurveDirections.size() - 1; idx >= 0; idx--) {
                    int nextDirection = (((dragonCurveDirections.get(idx) + 3) % 4) + 2) % 4;
                    endX += DIRS[nextDirection][0];
                    endY += DIRS[nextDirection][1];
                    isOnDragonCurve[endX][endY] = true;
                    dragonCurveDirections.add(nextDirection);
                }
            }
        }

        int wrapperDragonCurve = 0;
        for (int i = 0; i < 299; i++) {
            for (int j = 0; j < 299; j++) {
                if (isOnDragonCurve[i][j] && isOnDragonCurve[i + 1][j] && isOnDragonCurve[i][j + 1] && isOnDragonCurve[i + 1][j + 1]) {
                    wrapperDragonCurve++;
                }
            }
        }
        sb.append(wrapperDragonCurve);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
