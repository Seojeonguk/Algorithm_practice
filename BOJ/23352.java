import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer mapInfo = new StringTokenizer(br.readLine());
            int mapRowSize = Integer.parseInt(mapInfo.nextToken());
            int mapColSize = Integer.parseInt(mapInfo.nextToken());

            int[][] maps = new int[mapRowSize][mapColSize];
            for (int row = 0; row < mapRowSize; row++) {
                StringTokenizer rowInfo = new StringTokenizer(br.readLine());
                for (int col = 0; col < mapColSize; col++) {
                    maps[row][col] = Integer.parseInt(rowInfo.nextToken());
                }
            }

            int maxDist = 0, maxSum = 0;
            for (int row = 0; row < mapRowSize; row++) {
                for (int col = 0; col < mapColSize; col++) {
                    if (maps[row][col] == 0) {
                        continue;
                    }

                    int[] maxDistanceAndSum = calMaxDistanceAndSum(mapRowSize, mapColSize, maps, row, col);
                    if (maxDist < maxDistanceAndSum[0]) {
                        maxDist = maxDistanceAndSum[0];
                        maxSum = maxDistanceAndSum[1];
                    } else if (maxDist == maxDistanceAndSum[0]) {
                        maxSum = Math.max(maxSum, maxDistanceAndSum[1]);
                    }
                }
            }

            sb.append(maxSum);

            bw.write(sb.toString());
        }
    }

    public static int[] calMaxDistanceAndSum(int rowSize, int colSize, int[][] maps, int sx, int sy) {
        int[] maxDistanceAndSum = new int[2];

        boolean[][] isVisit = new boolean[rowSize][colSize];

        Queue<int[]> q = new LinkedList<>();
        isVisit[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (maxDistanceAndSum[0] < cur[2]) {
                maxDistanceAndSum[0] = cur[2];
                maxDistanceAndSum[1] = maps[sx][sy] + maps[cur[0]][cur[1]];
            } else if (maxDistanceAndSum[0] == cur[2]) {
                maxDistanceAndSum[1] = Math.max(maxDistanceAndSum[1], maps[sx][sy] + maps[cur[0]][cur[1]]);
            }

            for (int[] DIRECTION : DIRECTIONS) {
                int nx = cur[0] + DIRECTION[0];
                int ny = cur[1] + DIRECTION[1];

                if (isOut(rowSize, colSize, nx, ny) || isVisit[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }

                isVisit[nx][ny] = true;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }

        return maxDistanceAndSum;
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
