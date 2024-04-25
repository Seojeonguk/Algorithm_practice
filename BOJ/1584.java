import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_SIZE = 500;

    static final int DANGEROUS_AREA = 1;
    static final int DEATH_AREA = 2;

    static final int[][] DIRS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int[][] areas = new int[MAX_SIZE + 1][MAX_SIZE + 1];

            markingAreas(areas, DANGEROUS_AREA, br);
            markingAreas(areas, DEATH_AREA, br);

            sb.append(calMinLife(areas));

            bw.write(sb.toString());
        }
    }

    public static int calMinLife(int[][] areas) {
        int[][] dist = new int[MAX_SIZE + 1][MAX_SIZE + 1];
        for (int row = 0; row < MAX_SIZE + 1; row++) {
            Arrays.fill(dist[row], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int dir = 0; dir < DIRS.length; dir++) {
                int nx = cur[1] + DIRS[dir][0];
                int ny = cur[2] + DIRS[dir][1];

                if (isOut(nx, ny) || areas[nx][ny] == DEATH_AREA) {
                    continue;
                }

                int nd = cur[0] + areas[nx][ny];

                if (dist[nx][ny] > nd) {
                    dist[nx][ny] = nd;
                    pq.add(new int[]{nd, nx, ny});
                }
            }
        }

        return dist[MAX_SIZE][MAX_SIZE] == Integer.MAX_VALUE ? -1 : dist[MAX_SIZE][MAX_SIZE];
    }

    public static boolean isOut(int x, int y) {
        return (x < 0 || y < 0 || x > MAX_SIZE || y > MAX_SIZE);
    }

    public static void markingAreas(int[][] areas, int area, BufferedReader br) throws Exception {
        int areaCnt = Integer.parseInt(br.readLine());
        for (int areaNum = 0; areaNum < areaCnt; areaNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sx = Math.min(x1, x2), ex = Math.max(x1, x2);
            int sy = Math.min(y1, y2), ey = Math.max(y1, y2);

            for (int row = sx; row <= ex; row++) {
                for (int col = sy; col <= ey; col++) {
                    areas[row][col] = area;
                }
            }
        }
    }
}
