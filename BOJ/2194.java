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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int unitRowSize = Integer.parseInt(st.nextToken());
            int unitColSize = Integer.parseInt(st.nextToken());
            int obstacleCnt = Integer.parseInt(st.nextToken());

            boolean[][] isOnObstacle = new boolean[rowSize + 1][colSize + 1];
            for (int i = 0; i < obstacleCnt; i++) {
                StringTokenizer obstacleInfo = new StringTokenizer(br.readLine());
                int obstacleX = Integer.parseInt(obstacleInfo.nextToken());
                int obstacleY = Integer.parseInt(obstacleInfo.nextToken());

                isOnObstacle[obstacleX][obstacleY] = true;
            }

            Coordinate start = new Coordinate(new StringTokenizer(br.readLine()));
            Coordinate end = new Coordinate(new StringTokenizer(br.readLine()));

            sb.append(calMinMoveToTarget(rowSize, colSize, unitRowSize, unitColSize, isOnObstacle, start, end));

            bw.write(sb.toString());
        }
    }

    public static int calMinMoveToTarget(int rowSize, int colSize, int unitRowSize, int unitColSize, boolean[][] isOnObstacle, Coordinate start, Coordinate end) {
        int minMoveToTarget = -1;

        boolean[][] isVisit = new boolean[rowSize + 1][colSize + 1];
        isVisit[start.x][start.y] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Coordinate cur = q.poll();

            if (cur.x == end.x && cur.y == end.y) {
                minMoveToTarget = cur.cnt;
                break;
            }

            for (int[] DIRS : DIRECTIONS) {
                int nx = cur.x + DIRS[0];
                int ny = cur.y + DIRS[1];

                if (isOut(rowSize, colSize, nx, ny) || isVisit[nx][ny] || checkObstacle(rowSize, colSize, nx, ny, unitRowSize, unitColSize, isOnObstacle)) {
                    continue;
                }

                isVisit[nx][ny] = true;
                q.add(new Coordinate(nx, ny, cur.cnt + 1));
            }
        }

        return minMoveToTarget;
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 1 || y < 1 || x > rowSize || y > colSize);
    }

    public static boolean checkObstacle(int rowSize, int colSize, int x, int y, int unitRowSize, int unitColSize, boolean[][] isOnObstacle) {
        for (int i = 0; i < unitRowSize; i++) {
            for (int j = 0; j < unitColSize; j++) {
                int nx = x + i;
                int ny = y + j;
                if (isOut(rowSize, colSize, nx, ny) || isOnObstacle[nx][ny]) {
                    return true;
                }
            }
        }

        return false;
    }

    static class Coordinate {
        int x;
        int y;
        int cnt;

        public Coordinate(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Coordinate(StringTokenizer st) {
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cnt = 0;
        }
    }
}
