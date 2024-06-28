import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            int[] neutralizationTimes = new int[26];

            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int battleShipClassCnt = Integer.parseInt(st.nextToken());
                int width = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());

                Arrays.fill(neutralizationTimes, 0);

                for (int i = 0; i < battleShipClassCnt; i++) {
                    StringTokenizer battleShipTokenizer = new StringTokenizer(br.readLine());
                    char name = battleShipTokenizer.nextToken().charAt(0);
                    int neutralizationTime = Integer.parseInt(battleShipTokenizer.nextToken());

                    neutralizationTimes[name - 'A'] = neutralizationTime;
                }

                char[][] grid = new char[height][width];

                int enterpriseX = -1, enterpriseY = -1;
                for (int row = 0; row < height; row++) {
                    grid[row] = br.readLine().toCharArray();
                    for (int col = 0; col < width; col++) {
                        if (grid[row][col] == 'E') {
                            enterpriseX = row;
                            enterpriseY = col;
                        }
                    }
                }

                int minEscapeTime = getMinEscapeTime(height, width, neutralizationTimes, grid, enterpriseX, enterpriseY);
                sb.append(minEscapeTime).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int getMinEscapeTime(int rowSize, int colSize, int[] neutralizationTimes, char[][] grid, int enterpriseX, int enterpriseY) {
        int minEscapeTime = Integer.MAX_VALUE;

        PriorityQueue<Place> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        int[][] dist = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            Arrays.fill(dist[row], Integer.MAX_VALUE);
        }

        dist[enterpriseX][enterpriseY] = 0;
        pq.add(new Place(enterpriseX, enterpriseY, 0));
        while (!pq.isEmpty()) {
            Place place = pq.poll();

            if (isCorner(rowSize, colSize, place.x, place.y)) {
                minEscapeTime = Math.min(minEscapeTime, place.time);
            }

            for (int[] DIRECTION : DIRECTIONS) {
                int nx = place.x + DIRECTION[0];
                int ny = place.y + DIRECTION[1];

                if (isOut(rowSize, colSize, nx, ny)) {
                    continue;
                }

                int nTime = place.time + neutralizationTimes[grid[nx][ny] - 'A'];
                if (nTime < dist[nx][ny]) {
                    dist[nx][ny] = nTime;
                    pq.add(new Place(nx, ny, nTime));
                }
            }
        }

        return minEscapeTime;
    }

    public static boolean isCorner(int rowSize, int colSize, int x, int y) {
        return (x == 0 || y == 0 || x == rowSize - 1 || y == colSize - 1);
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }

    static class Place {
        int x, y;
        int time;

        public Place(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
